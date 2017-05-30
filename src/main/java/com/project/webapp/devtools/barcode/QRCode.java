/**
 * 
 */
package com.project.webapp.devtools.barcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.EnumMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class QRCode {

	@RequestMapping(value="qrcode/{text}/backcolor/{backcolor}/forecolor/{forecolor}/pixel/{pixel}/type/{type}/ecl/{ecl}", method=RequestMethod.GET)
	public String generateQRBarCode(@PathVariable("text") String text, @PathVariable("backcolor") String backcolor,@PathVariable("forecolor") String forecolor,@PathVariable("pixel") String pixel, @PathVariable("type") String type,@PathVariable("ecl") String ecl) throws WriterException, UnirestException{
	
		HttpResponse<String> response = Unirest.get("https://pierre2106j-qrcode.p.mashape.com/api?backcolor="+backcolor+"&ecl=L+%7C+M%7C+Q+%7C+H&forecolor="+forecolor+"&pixel="+pixel+"&text="+text+"&type=text+%7C+url+%7C+tel+%7C+sms+%7C+email")
				.header("X-Mashape-Key", "58Lkq0o1JKmshke2gVhQnQByXO3zp18P2mwjsnaIhmQWmKAsr3")
				.header("Accept", "text/plain")
				.asString();
		return response.getBody();	
	}
	
	@RequestMapping(value="/barcode/{id}/qrcode", method=RequestMethod.GET)
	public BitMatrix generateBarCode(@PathVariable String id) throws WriterException{
		
		int size = 250;
		String fileType = "png";
		String filePath = "file://C:/Testing/QRGenerated.png";
		File myFile = new File(filePath);
		
//		try{
			Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
			hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
	
			hintMap.put(EncodeHintType.MARGIN, 1); /* default = 4 */
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
	
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			
			BitMatrix byteMatrix = qrCodeWriter.encode(id, BarcodeFormat.QR_CODE, size,
					size, hintMap);
			
		
			int CrunchifyWidth = byteMatrix.getWidth();
		
			BufferedImage image = new BufferedImage(CrunchifyWidth, CrunchifyWidth,
					BufferedImage.TYPE_INT_RGB);
			image.createGraphics();
	
			Graphics2D graphics = (Graphics2D) image.getGraphics();
			graphics.setColor(Color.WHITE);
			graphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth);
			graphics.setColor(Color.BLACK);
	
			for (int i = 0; i < CrunchifyWidth; i++) {
				for (int j = 0; j < CrunchifyWidth; j++) {
					if (byteMatrix.get(i, j)) {
						graphics.fillRect(i, j, 1, 1);
					}
				}
			}
			
		
			
			return byteMatrix;
			/*
			
			
			 * //  Write Barcode
            bitMatrix = new Code128Writer().encode("123456789", BarcodeFormat.CODE_128, 150, 80, null);
            MatrixToImageWriter.writeToStream(bitMatrix, "png", new FileOutputStream(new File("D://code128_123456789.png")));
            System.out.println("Code128 Barcode Generated.");
//  Write QR Code
            bitMatrix = writer.encode("123456789", BarcodeFormat.QR_CODE, 200, 200);
            MatrixToImageWriter.writeToStream(bitMatrix, "png", new FileOutputStream(new File("D://qrcode_123456789.png")));
            System.out.println("QR Code Generated.");
//  Write PDF417
            writer = new PDF417Writer();
            bitMatrix = writer.encode("123456789", BarcodeFormat.PDF_417, 80, 150);
            MatrixToImageWriter.writeToStream(bitMatrix, "png", new FileOutputStream(new File("D://pdf417_123456789.png")));
            System.out.println("PDF417 Code Generated.");
            
            
			ImageIO.write(image, fileType, myFile);*/
		
		/*}
		catch (WriterException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}*/
	}


}
