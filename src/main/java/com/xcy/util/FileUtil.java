package com.xcy.util;

import java.io.File;
import java.io.FileOutputStream;
/**
 * 
 * @author 图片工具类
 *
 */
public class FileUtil {
	/**
	 * 上传图片工具类
	 * @param file
	 * @param filePath
	 * @param fileName
	 * @throws Exception
	 */
		public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception{
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
	
	/**处理文件上传
    @RequestMapping(value="/uploadimg", method = RequestMethod.POST)
    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file,
                                          HttpServletRequest request) {
    	

        @SuppressWarnings("unused")
		String contentType = file.getContentType();   //图片文件类型
        String fileName = file.getOriginalFilename();  //图片名字

        //文件存放路径
        String filePath = "E:\\photo\\";
        
        //调用文件处理类FileUtil，处理文件，将文件写入指定位置
       try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        	e.printStackTrace();
        }	
       // 返回图片的存放路径
        return JSON.toJSONString(JSONResult.ok(filePath));
    }**/
}
