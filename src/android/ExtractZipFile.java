package org.reallyenglish;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONException;

public class ExtractZipFile extends CordovaPlugin {

    @Override
    public boolean execute(String action, CordovaArgs args, final CallbackContext callbackContext) throws JSONException {
        if ("extract".equals(action)) {
            extract(args, callbackContext);
            return true;
        }
        return false;
    }

    private void extract(CordovaArgs args, CallbackContext callbackContext) {
        try {
            String filename = args.getString(0);
            String outputDirectory = args.getString(1);
            outputDirectory += outputDirectory.endsWith(File.separator) ? "" : File.separator;

            File file = new File(filename);
            ZipInputStream zis = new ZipInputStream(new FileInputStream(file));

            ZipEntry entry;

            byte[] buffer = new byte[1024];

            while ((entry = zis.getNextEntry()) != null) {
                String fileName = outputDirectory + entry.getName();
                File outFile = new File(fileName);

                if (entry.isDirectory()) {
                    outFile.mkdirs();
                } else {
                    outFile.getParentFile().mkdirs();
                    if(outFile.exists() || outFile.createNewFile()){
                        FileOutputStream fout = new FileOutputStream(outFile);
                        int count;
                        while ((count = zis.read(buffer)) != -1) {
                            fout.write(buffer, 0, count);
                        }
                        fout.close();
                    }
                }
                zis.closeEntry();
            }
            zis.close();
            callbackContext.success(filename);
        } catch (Exception e) {
          callbackContext.error("error occurred" + e.getMessage());
        }
    }
}
