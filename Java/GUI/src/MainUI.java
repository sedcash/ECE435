import org.json.JSONException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MainUI implements Runnable
{
    private JFrame frame;
    private JTextField searchInput;
    private JPanel displayPanel;

    @Override
    public void run(){
        initUI();
    }

    private void initUI(){
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel searchLabel = new JLabel("Search: ");
        searchInput = new JTextField(15);
        searchInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // no-op
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submit();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // no-op
            }
        });

        JButton clear = new JButton("clear");
        clear.addActionListener(e -> clearInput());

        JButton submit = new JButton("submit");
        submit.addActionListener(e -> createDisplay());

        topPanel.add(searchLabel);
        topPanel.add(searchInput);
        topPanel.add(clear);
        topPanel.add(submit);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
    }

    public void createDisplay(){
        int row = 5;
        int col = 5;
        displayPanel = new JPanel(new GridLayout());

        Map<String, Album> albums = null;
        String artist = searchInput.getText();

        try {
            albums = Itunes.getAlbums(artist);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Iterator it = albums.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Album album = (Album) pair.getValue();
            JPanel temp = null;
            // avoids a ConcurrentModificationException
            try {
                temp = getAlbumPanel(album);
            } catch (IOException e) {
                e.printStackTrace();
            }
            displayPanel.add(temp);
            it.remove();
        }

        displayPanel.setMaximumSize(new Dimension(1200, 1200));
        frame.add(displayPanel, BorderLayout.CENTER);
        frame.pack();
    }

    private void hideDisplay(){
        displayPanel.removeAll();
        frame.remove(displayPanel);
        frame.pack();
    }

    private void clearInput(){
        searchInput.setText("");
        hideDisplay();
    }

    private void submit(){
        if(searchInput.getText() != ""){
            if(displayPanel != null){
                frame.remove(displayPanel);
                displayPanel = null;
                frame.pack();
            }
            createDisplay();
        }
    }

    private JPanel getAlbumPanel(Album album) throws IOException {
        JPanel containerPanel = new JPanel(new BorderLayout());
        JPanel iconPanel = new JPanel(new BorderLayout());
        JPanel textPanel = new JPanel(new BorderLayout());

        URL url = new URL(album.image);
        Image image = ImageIO.read(url);
        ImageIcon icon = new ImageIcon(image);
        JLabel iconLabel = new JLabel(icon, SwingConstants.CENTER);
        JLabel textLabel = new JLabel(album.title, SwingConstants.CENTER);

        iconPanel.add(iconLabel);
        textPanel.add(textLabel);

        containerPanel.add(iconPanel, BorderLayout.NORTH);
        containerPanel.add(textPanel, BorderLayout.CENTER);

        containerPanel.setMaximumSize(new Dimension(100, 100));

        return containerPanel;
        
    }


}
