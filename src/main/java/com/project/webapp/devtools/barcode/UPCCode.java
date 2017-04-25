/**
 * 
 */
package com.project.webapp.devtools.barcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.oned.UPCEANWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class UPCCode {

	@RequestMapping(value="/barcode/{id}/upca", method=RequestMethod.GET)
	public void generateBarCode(@PathVariable String id){
		
		int size = 250;
		String fileType = "png";
		String filePath = "file://C:/Testing/Code128Generated.png";
		File myFile = new File(filePath);
		
		try{
			Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
			hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
	
			hintMap.put(EncodeHintType.MARGIN, 1); /* default = 4 */
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
				
			UPCAWriter upcaWriter = new UPCAWriter();
	
			BitMatrix byteMatrix = upcaWriter.encode(id, BarcodeFormat.UPC_A, size,
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
			
			ImageIO.write(image, fileType, myFile);
		
		}
		catch (WriterException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}



	@RequestMapping(value="/barcode/{id}/upcean", method=RequestMethod.GET)
	public void generateBarCodeUPCE(@PathVariable String id){
		
		int size = 250;
		String fileType = "png";
		String filePath = "file://C:/Testing/Code128Generated.png";
		File myFile = new File(filePath);
		
		try{
			Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
			hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
	
			hintMap.put(EncodeHintType.MARGIN, 1); /* default = 4 */
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
				
			UPCEANWriter upcEANWriter = new UPCEANWriter() {
				
				@Override
				public boolean[] encode(String paramString) {
					// TODO Auto-generated method stub
					return null;
				}
			};
	
			BitMatrix byteMatrix = upcEANWriter.encode(id, BarcodeFormat.UPC_E, size,
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
			
			ImageIO.write(image, fileType, myFile);
		
		}
		catch (WriterException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}





}
