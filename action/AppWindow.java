package action;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class AppWindow extends BaseWindow {

    private JPanel jContentPane = null;
    private JButton jButton = null;
    public JTextField jText = null;
    public JTextField jText2 = null;
    public JTextField jText3 = null;

    public int mainWidth = 600;
    public int mainHeight = 400;
    public String titleString = "Swing 簡易入力サンプル( GridLayout )";

    // *****************************************************
    // ボタン作成とクリックイベント
    // *****************************************************
    private JButton getJButton() {
        if (jButton == null) {
            jButton = new JButton();
            jButton.setText("実行");
            jButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {

                    AppWindow.this.MsgOk("ボタンがクリックされました");
                    System.out.println("ボタンがクリックされました");

                    try {
                        // ボタン処理用クラスの呼び出し
                        Action.testProc(AppWindow.this);

                    }
                    catch ( Exception ex ) {
                        ex.printStackTrace();
                    }

                }
            });
        }
        return jButton;
    }

    // *****************************************************
    // コンストラクタ
    // *****************************************************
    public AppWindow() {
        super();
        initialize();
    }

    // *****************************************************
    // 初期処理
    // *****************************************************
    private void initialize() {
        // ウインドウサイズの決定
        this.setSize(mainWidth, mainHeight);

        // ウインドウ位置の変更
        centerWindow(-200);

        // パネルを適用
        this.setContentPane(getJContentPane());

        // タイトルセット
        this.setTitle(titleString);

        // カレントディレクトリの表示
        File cur = new File("");
        System.out.println(cur.getAbsolutePath());
    }

    // *****************************************************
    // 画面( パネル作成 )
    // *****************************************************
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            GridLayout layout = new GridLayout(10,1);
            layout.setVgap(10);  //垂直方向の間隔
            jContentPane.setLayout(layout);

            // 入力フィールド
            jText = new JTextField();
            jText.setText("1234567890");
            jContentPane.add(jText);
            // 入力フィールド2
            jText2 = new JTextField();
            jText2.setText("ABCDEFG");
            jContentPane.add(jText2);
            // 入力フィールド3
            jText3 = new JTextField();
            jText3.setText("日本語表示");
            jContentPane.add(jText3);

            jContentPane.add(getJButton());
        }
        return jContentPane;
    }

}
