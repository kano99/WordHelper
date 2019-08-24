import view.ReplacePanel;

import javax.swing.*;

/**
 * @author Kano
 * @createTime 24 15:10
 * @description
 */
class WordHelper extends JFrame {
    WordHelper(String title) {
        super(title);
        init();
        add(new ReplacePanel(this));
        setVisible(true);
    }

    private void init(){
        setSize(500,350);
        //setResizable(false);
        setLocation(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
