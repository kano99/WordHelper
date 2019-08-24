package view;


import util.ReplaceUtil;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.StringTokenizer;

/**
 * @author Kano
 * @createTime 24 15:14
 * @description 文本替换界面
 */
public class ReplacePanel extends JPanel {
    private JFrame jFrame;
    private JPanel thisPanel;
    private JTextArea inputArea, outputArea;
    private JLabel jLabel;
    private JTextArea originArea, replaceArea;
    private JButton btnClick;

    public ReplacePanel(JFrame jFrame){
        this.thisPanel = this;
        this.jFrame = jFrame;

        //对界面进行初始化
        initUI();
        //对一些控件进行事件监听
        addListeners();


    }


    private void initUI() {
        this.setLayout(null);
        //大输入框
        inputArea = new JTextArea(20,15);
        outputArea = new JTextArea(20,15);

        //替换输入框和“替换”按钮
        jLabel = new JLabel("将");
        originArea = new JTextArea(5,15);
        btnClick = new JButton("替换成");
        replaceArea = new JTextArea(5,15);

        inputArea.setLineWrap(true);        //激活自动换行功能（句子过长时，将句子断开换行显示）
        inputArea.setWrapStyleWord(true);   // 激活断行不断字功能(单词过长时将单词移到下一行）
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        originArea.setLineWrap(true);
        originArea.setWrapStyleWord(true);
        replaceArea.setLineWrap(true);
        replaceArea.setWrapStyleWord(true);

        int width = jFrame.getWidth();
        int height = jFrame.getHeight();
        inputArea.setBounds(5,5,(int)(width * 0.4) - 10, height - 50);
        outputArea.setBounds((int)(width * 0.6),5,(int)(width * 0.4) - 20, height - 50);
        jLabel.setBounds(width/2 -10,10,80,20);
        originArea.setBounds((int)(width * 0.42),40,(int)(width * 0.16) ,(int)(height*0.3));
        btnClick.setBounds((int)(width * 0.5-40),60 + (int)(height*0.3),80 ,20);
        replaceArea.setBounds((int)(width * 0.42),100 + (int)(height*0.3),(int)(width * 0.16) ,(int)(height*0.3));

        add(inputArea);
        add(outputArea);
        add(jLabel);
        add(btnClick);
        add(originArea);
        add(replaceArea);
    }

    private void addListeners() {

        jFrame.addComponentListener(new ComponentAdapter(){
            @Override public void componentResized(ComponentEvent e){
                int width = jFrame.getWidth();
                int height = jFrame.getHeight();
                inputArea.setBounds(5,5,(int)(width * 0.4) - 10, height - 50);
                outputArea.setBounds((int)(width * 0.6),5,(int)(width * 0.4) - 20, height - 50);

                jLabel.setBounds(width/2 -10,10,80,20);
                originArea.setBounds((int)(width * 0.42),40,(int)(width * 0.16) ,(int)(height*0.3));
                btnClick.setBounds((int)(width * 0.5-40),60 + (int)(height*0.3),80 ,20);
                replaceArea.setBounds((int)(width * 0.42),100 + (int)(height*0.3),(int)(width * 0.16) ,(int)(height*0.3));
            }
        });

        btnClick.addActionListener((e)->{
            String resultString = "";
            String[] replaceStrings = replaceArea.getText().split("%\n");
            for(String replace: replaceStrings){
                resultString = resultString +  ReplaceUtil.doReplace(inputArea.getText(),originArea.getText(),replace) + "\n\n";
            }
            outputArea.setText(resultString);

        });

    }

}
