package SwingWorker;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwingWorkerWithProgressBar extends JFrame {

    private JPanel contentPane;
    private JProgressBar progressBar;

    private int progressBarValue;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SwingWorkerWithProgressBar frame = new SwingWorkerWithProgressBar();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public SwingWorkerWithProgressBar() {
        progressBarValue = 0;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        progressBar = new JProgressBar(0, 100);
        contentPane.add(progressBar, BorderLayout.NORTH);

        JButton btnBegin = new JButton("Test");
        btnBegin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ProgressBarRealized().execute();
            }
        });
        contentPane.add(btnBegin, BorderLayout.SOUTH);
    }

    class ProgressBarRealized extends SwingWorker<Void, Integer> {

        @Override
        //后台任务在此方法中实现
        protected Void doInBackground() throws Exception {
            // 模拟有一百项任务，每次睡1s
            for (int i = 1; i <= 100; i++) {
                Thread.sleep(1000);
                publish(i);//将当前进度信息加入chunks中
            }
            return null;
        }
        @Override
        //每次更新进度条的信息
        protected void process(List<Integer> chunks) {
            progressBar.setValue(chunks.get(chunks.size() - 1));
        }
        @Override
        //任务完成后返回一个信息
        protected void done() {
            JOptionPane.showMessageDialog(null, "任务完成！");
        }
    }
}

// https://www.cnblogs.com/mhzhou-whyj/p/7832840.html