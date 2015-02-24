package seminari.notepad;

import java.util.Vector;

import com.trolltech.qt.core.QRegExp;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QBrush;
import com.trolltech.qt.gui.QColor;
import com.trolltech.qt.gui.QFont;
import com.trolltech.qt.gui.QSyntaxHighlighter;
import com.trolltech.qt.gui.QTextCharFormat;
import com.trolltech.qt.gui.QTextDocument;

class Highlighter extends QSyntaxHighlighter {

    public class HighlightingRule {
        public QRegExp pattern;
        public QTextCharFormat format;

        public HighlightingRule(QRegExp pattern, QTextCharFormat format) {
            this.pattern = pattern;
            this.format = format;
        }
    }

    Vector<HighlightingRule> highlightingRules = new Vector<HighlightingRule>();

    QRegExp commentStartExpression;
    QRegExp commentEndExpression;

    QTextCharFormat keywordFormat = new QTextCharFormat();
    QTextCharFormat classFormat = new QTextCharFormat();
    QTextCharFormat commentFormat = new QTextCharFormat();
    QTextCharFormat quotationFormat = new QTextCharFormat();
    QTextCharFormat functionFormat = new QTextCharFormat();

    public Highlighter(QTextDocument parent) {

        super(parent);

        HighlightingRule rule;
        QBrush brush;
        QRegExp pattern;

        brush = new QBrush(QColor.darkBlue,Qt.BrushStyle.SolidPattern);
        keywordFormat.setForeground(brush);
        keywordFormat.setFontWeight(QFont.Weight.Bold.value());

        // All the java keywords
        String[] keywords = { "abstract", "continue", "for", "new",
                              "switch", "assert", "default", "goto",
                              "package", "synchronized", "boolean",
                              "do", "if", "private", "this", "break",
                              "double", "implements", "protected",
                              "throw", "byte", "else", "import",
                              "public", "throws", "case", "enum",
                              "instanceof", "return", "transient",
                              "catch", "extends", "int", "short",
                              "try", "char", "final", "interface",
                              "static", "void", "class", "finally",
                              "long", "strictfp", "volatile", "const",
                              "float", "native", "super", "while" };

        for (String keyword : keywords) {
            pattern = new QRegExp("\\b" + keyword + "\\b");
            rule = new HighlightingRule(pattern, keywordFormat);
            highlightingRules.add(rule);
        }

        // Any word starting with Q
        brush = new QBrush(QColor.darkMagenta);
        pattern = new QRegExp("\\bQ[A-Za-z]+\\b");
        classFormat.setForeground(brush);
        classFormat.setFontWeight(QFont.Weight.Bold.value());
        rule = new HighlightingRule(pattern, classFormat);
        highlightingRules.add(rule);

        // Comment starting with //
        brush = new QBrush(QColor.gray, Qt.BrushStyle.SolidPattern);
        pattern = new QRegExp("//[^\n]*");
        commentFormat.setForeground(brush);
        rule = new HighlightingRule(pattern, commentFormat);
        highlightingRules.add(rule);

        // String
        brush = new QBrush(QColor.blue, Qt.BrushStyle.SolidPattern);
        pattern = new QRegExp("\".*\"");
        pattern.setMinimal(true);
        quotationFormat.setForeground(brush);
        rule = new HighlightingRule(pattern, quotationFormat);
        highlightingRules.add(rule);

        // Function
        brush = new QBrush(QColor.darkGreen, Qt.BrushStyle.SolidPattern);
        pattern = new QRegExp("\\b[A-Za-z0-9_]+(?=\\()");
        functionFormat.setForeground(brush);
        functionFormat.setFontItalic(true);
        rule = new HighlightingRule(pattern, functionFormat);
        highlightingRules.add(rule);

        // Block comment
        commentStartExpression = new QRegExp("/\\*");
        commentEndExpression = new QRegExp("\\*/");
    }

    @Override
    public void highlightBlock(String text) {

        for (HighlightingRule rule : highlightingRules) {
            QRegExp expression = rule.pattern;
            int index = expression.indexIn(text);
            while (index >= 0) {
                int length = expression.matchedLength();
                setFormat(index, length, rule.format);
                index = expression.indexIn(text, index + length);
            }
        }
        setCurrentBlockState(0);

        int startIndex = 0;
        if (previousBlockState() != 1)
            startIndex = commentStartExpression.indexIn(text);

        while (startIndex >= 0) {
            int endIndex = commentEndExpression.indexIn(text, startIndex);
            int commentLength;
            if (endIndex == -1) {
                setCurrentBlockState(1);
                commentLength = text.length() - startIndex;
            } else {
                commentLength = endIndex - startIndex + commentEndExpression.matchedLength();
            }
            setFormat(startIndex, commentLength, commentFormat);
            startIndex = commentStartExpression.indexIn(text, startIndex + commentLength);
        }
    }
}
