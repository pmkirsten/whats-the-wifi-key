package es.pmkirsten.engine;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WifiKeyEngine {

	private static final String CMD_SSID = "cmd /c netsh wlan show interfaces | find /I \"SSID\"";
	private static final String CMD_KEY_1 = "cmd /c netsh wlan show profile key=clear name=";
	private static final String KeyContentPattern = ".*Contenido de la clave.*|.*Key Content.*";
	private String ssid = "";
	private String wifiKey = "";

	public String getSSID() {
		return this.ssid;
	}

	public void run() {
		try {
			// Run "netsh" Windows command
			Process process = Runtime.getRuntime().exec(WifiKeyEngine.CMD_SSID);

			// Get input streams
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

			// Read command standard output
			String s;
			while ((s = stdInput.readLine()) != null) {
				if (s.trim().startsWith("SSID")) {
					this.ssid = s.substring(s.indexOf(":") + 1).trim();
					break;
				}
			}
			process = Runtime.getRuntime().exec(WifiKeyEngine.CMD_KEY_1 + this.ssid);
			stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while ((s = stdInput.readLine()) != null) {
				if (s.matches(WifiKeyEngine.KeyContentPattern)) {
					this.wifiKey = s.substring(s.indexOf(":") + 1).trim();
				}
			}

		} catch (Exception e) {
			this.wifiKey = "ERROR: No se ha podido recuperar la clave";
		}

	}

	public String getWifiKey() {
		return this.wifiKey;
	}

	public static void main(String[] args) {
		WifiKeyEngine wke = new WifiKeyEngine();
		wke.run();
		System.out.println(wke.getSSID());
		System.out.println(wke.getWifiKey());
	}
}
