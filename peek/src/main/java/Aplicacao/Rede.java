package Aplicacao;

import java.net.SocketException;

import oshi.SystemInfo;
import oshi.util.FormatUtil;

public class Rede {
	private SystemInfo systemInfo = null;
	
	/**
	 * @return Retorna a velocidade da rede em bits
	 */
	
	public int getTotalInterfaces() {
		systemInfo = new SystemInfo();
		return systemInfo.getHardware().getNetworkIFs().length;
	}
	
	public String[] getMacsPC() {
		systemInfo = new SystemInfo();
		systemInfo.getHardware().getNetworkIFs()[0].getMacaddr();
		
		int index = systemInfo.getHardware().getNetworkIFs().length;
		
		String[] macs = new String[index];
		
		for(int i = 0; i < index; i++) {
			macs[i] = systemInfo.getHardware().getNetworkIFs()[i].getMacaddr();
		}
		
		return macs;
	}
	
	public String getVelocidadeDownload() {
		systemInfo = new SystemInfo();
		
		systemInfo.getHardware()
			.getNetworkIFs()[getInterfaceEmUso()]
					.updateNetworkStats();
		
		return FormatUtil.formatBytes(systemInfo.getHardware()
				.getNetworkIFs()[getInterfaceEmUso()]
						.getBytesSent());
	}
	
	public String getVelocidadeUpload() {
		systemInfo = new SystemInfo();
		
		systemInfo.getHardware()
		.getNetworkIFs()[getInterfaceEmUso()]
				.updateNetworkStats();
		
		return FormatUtil.formatBytes(systemInfo.getHardware()
				.getNetworkIFs()[getInterfaceEmUso()]
						.getBytesRecv());
	}
	
	public long getVelocidadeInterface() {	
		systemInfo = new SystemInfo();
		return systemInfo.getHardware().getNetworkIFs()[getInterfaceEmUso()].getSpeed();		
	}

	public String getIPv4() {
		systemInfo = new SystemInfo();
		String[] redes = systemInfo.getHardware().getNetworkIFs()[getInterfaceEmUso()].getIPv4addr();
		String infos = "";
		for(int i = 0; i < redes.length; i++) {
			infos += redes[i];
		}
		return infos;
	}
	
	public String getIPv6() {
		systemInfo = new SystemInfo();
		String[] redes = systemInfo.getHardware().getNetworkIFs()[getInterfaceEmUso()].getIPv6addr();
		String infos = "";
		for(int i = 0; i < redes.length; i++) {
			infos += redes[i];
		}
		return infos;
	}
	
	public String getMAC() {		
		systemInfo = new SystemInfo();
		return systemInfo.getHardware().getNetworkIFs()[getInterfaceEmUso()].getMacaddr();		
	}

	public String getAdaptadorDeRede() {
		systemInfo = new SystemInfo();
		return systemInfo.getHardware().getNetworkIFs()[getInterfaceEmUso()].getDisplayName();
	}
	
	
	private int getInterfaceEmUso() {
		systemInfo = new SystemInfo();
		
		for(int i = 0; i < systemInfo.getHardware().getNetworkIFs().length; i++) {
			if(!systemInfo.getHardware().getNetworkIFs()[i].getDisplayName().trim().equals(""))
				return i;
		}
		
		return -1;
	}
	
}
