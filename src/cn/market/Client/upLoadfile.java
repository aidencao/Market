package cn.market.Client;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import cn.market.tools.DefinedChars;

public class upLoadfile {
	
	public static String upload(String path, String macId) throws Exception{
		//本地文件上传，直接指定文件的完整路径即可上传。
		//构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone2());
		//其他参数参考类注释
		UploadManager uploadManager = new UploadManager(cfg);
		//生成上传凭证，然后准备上传
		String accessKey = "PrLvZACIUizs22Fb6Bvt9oFJr2KdaYfUACx8CY7e";
		String secretKey = "MnTDPKUhxrmSJs_Gp7YHjvUg4MOp7yXE7W_X0eM0";
		String bucket = "uestc711";
		//如果是Windows情况下，格式是 D:\\qiniu\\test.png
		String localFilePath = path;
		//默认不指定key的情况下，以文件内容的hash值作为文件名
		String key = macId+".png";
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket,key);
		String newpath = null;
		try {
		    Response response = uploadManager.put(localFilePath, key, upToken);
		    //解析上传成功的结果
		    DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
		    System.out.println(putRet.key);
		    System.out.println(putRet.hash);
		    newpath = DefinedChars.QINIU+key;
		} catch (QiniuException ex) {
		   System.out.println(ex.toString());
		   newpath = DefinedChars.QINIU+key;
		  /* throw new Exception("上传过程出错,图片已由别处上传"+ex.toString());*/
		}catch(Exception e)
		{
			throw new Exception("上传出错"+e.toString());
		}
		return newpath;
	}
	
		
	public static void main(String[] args) {
		/*upLoadfile.upload();*/
	}
}
