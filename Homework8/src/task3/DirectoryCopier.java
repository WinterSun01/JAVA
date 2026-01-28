package task3;

import java.io.*;

class DirectoryCopier implements Runnable
{
    private File source;
    private File target;

    private int filesCopied = 0;
    private int dirsCreated = 0;

    public DirectoryCopier(String sourcePath, String targetPath)
    {
        this.source = new File(sourcePath);
        this.target = new File(targetPath);
    }

    @Override
    public void run()
    {
        if (!source.exists() || !source.isDirectory())
        {
            System.out.println("Исходная директория не существует!");
            return;
        }

        copyDirectory(source, target);
    }

    private void copyDirectory(File src, File dst)
    {
        if (!dst.exists())
        {
            dst.mkdirs();
            dirsCreated++;
        }

        File[] files = src.listFiles();
        if (files == null) return;

        for (File file : files)
        {
            File newFile = new File(dst, file.getName());

            if (file.isDirectory())
            {
                copyDirectory(file, newFile);
            }
            else
            {
                copyFile(file, newFile);
                filesCopied++;
            }
        }
    }

    private void copyFile(File src, File dst)
    {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst))
        {
            byte[] buffer = new byte[1024];
            int length;

            while ((length = in.read(buffer)) > 0)
            {
                out.write(buffer, 0, length);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public int getFilesCopied()
    {
        return filesCopied;
    }

    public int getDirsCreated()
    {
        return dirsCreated;
    }
}
