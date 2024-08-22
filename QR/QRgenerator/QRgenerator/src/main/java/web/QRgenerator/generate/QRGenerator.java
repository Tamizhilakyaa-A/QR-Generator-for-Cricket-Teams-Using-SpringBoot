package web.QRgenerator.generate;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import web.QRgenerator.util.CricketTeam;

public class QRGenerator {

	public static void generateQRCode(CricketTeam cricketTeam) throws WriterException, IOException {
		String qrcodepath = "C:\\ADVANCED JAVA\\QR Code";
		String qrcodename = qrcodepath + cricketTeam.getTeamName() + cricketTeam.getTeamId() + "-qr.png";
		var qrcodewriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrcodewriter.encode(
				"Id: " + cricketTeam.getTeamId() + "\n" + "teamName: " + cricketTeam.getTeamName() + "\n"
						+ "teamColor: " + cricketTeam.getTeamColor() + "\n" + "managerName: "
						+ cricketTeam.getManagerName() + "\n" + "teamEmail: " + cricketTeam.getTeamEmail(),
				BarcodeFormat.QR_CODE, 400, 400);
		Path path = FileSystems.getDefault().getPath(qrcodename);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	}
}
