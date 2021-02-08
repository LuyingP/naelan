package fr.naelan.projet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Pcl> listFiles = getFiles("C:\\Users\\stagiaire\\Desktop\\TestTechnique", new ArrayList<Pcl>());
		listFiles.forEach(x -> System.out.print("Nom: " + x.getNom() + "\t" + " Taille: " + x.getTaille() + " bytes"
				+ "\t" + " Type: " + x.getType() + "\n"));

	}

	public static List<Pcl> getFiles(String path, ArrayList<Pcl> listFiles) {
		if (path != null && path.length() != 0) {
			File file = new File(path);
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				if (files != null) {
					for (int i = 0; i < files.length; i++) {
						if (files[i].isDirectory()) {
							getFiles(files[i].getPath() + File.separator, listFiles);
						} else {
							if (files[i].getName().toLowerCase().endsWith(".pcl")) {
								listFiles.add(new Pcl(files[i].length(), files[i].getName(), getFileType(files[i])));
							}
						}
					}
				}
			} else {
				if (file.getName().toLowerCase().endsWith(".pcl")) {
					listFiles.add(new Pcl(file.length(), file.getName()));
				}
			}

		}
		Collections.sort(listFiles);

		return listFiles;
	}

	public static boolean ReadOneFile(File f) {
		String currentLine = "";
		String firstLine = "";

		File file = new File(f.getAbsolutePath());
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			if ((currentLine = br.readLine()) != null) {
				firstLine = currentLine;
				String[] str = firstLine.split("&");
				return str[5].substring(0, 3).contains("l0S") ? true : false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}

	public static String getFileType(File f) {
		Pcl p = new Pcl();
		if (ReadOneFile(f)) {
			p.setType(TypeFichier.SIMPLEX.toString());
			return TypeFichier.SIMPLEX.toString();
		} else {
			p.setType(TypeFichier.SIMPLEX.toString());
			return TypeFichier.DUPLEX.toString();
		}

	}

}
