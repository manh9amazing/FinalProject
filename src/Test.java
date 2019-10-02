import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.text.AttributedString;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JPanel {

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        drawParagraph(g2d, "adfasdfaf", 20);
    }

    void drawParagraph(Graphics2D g, String paragraph, float width) {
        LineBreakMeasurer linebreaker = new LineBreakMeasurer(new AttributedString(paragraph)
                .getIterator(), g.getFontRenderContext());
        int y = 0;
        while (linebreaker.getPosition() < paragraph.length()) {
            TextLayout textLayout = linebreaker.nextLayout(width);
            y += textLayout.getAscent();
            textLayout.draw(g, 0, y);
            y += textLayout.getDescent() + textLayout.getLeading();
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Basic Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Test());
        frame.setSize(350, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}