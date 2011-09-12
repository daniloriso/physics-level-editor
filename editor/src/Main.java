
import aurelienribon.leveleditor.AppManager;
import aurelienribon.leveleditor.AssetsManager;
import aurelienribon.leveleditor.models.AssetInfo;
import aurelienribon.leveleditor.ui.MainWindow;
import aurelienribon.leveleditor.utils.AssetLoader;
import com.badlogic.gdx.backends.lwjgl.LwjglCanvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class Main {
    public static void main(final String[] args) {
		makeWindow();

		System.out.println("universal-level-editor | Aurelien Ribon | 2011");
		System.out.println("Welcome!\n");
    }

	private static void makeWindow() {
		final LwjglCanvas glCanvas = new LwjglCanvas(AppManager.instance().getRenderPanel(), false);

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception ex) {}

				MainWindow mw = new MainWindow(glCanvas.getCanvas());
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				mw.setSize(
					Math.min(1250, screenSize.width - 100),
					Math.min(850, screenSize.height - 100)
				);
				mw.setLocationRelativeTo(null);
				mw.setVisible(true);

				debug(mw);
			}
		});
	}

	private static void debug(MainWindow mw) {
		mw.addWindowListener(new WindowAdapter() {
			@Override public void windowOpened(WindowEvent e) {
				AssetsManager.instance().add(AssetLoader.getAssetInfo("data/hero.png"));
				AssetsManager.instance().add(AssetLoader.getAssetInfo("data/sun.png"));
				AssetsManager.instance().add(AssetLoader.getAssetInfo("data/platform1.png"));
				AssetsManager.instance().add(AssetLoader.getAssetInfo("data/platform2.png"));
			}
		});
	}
}
