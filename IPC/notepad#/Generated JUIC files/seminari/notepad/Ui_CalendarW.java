/********************************************************************************
** Form generated from reading ui file 'Calendar.jui'
**
** Created: ju. 25. abr. 19:01:18 2013
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package seminari.notepad;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_CalendarW implements com.trolltech.qt.QUiForm<QWidget>
{
    public QVBoxLayout verticalLayout;
    public QCalendarWidget dateWidget;
    public QHBoxLayout horizontalLayout;
    public QLineEdit dateTextEdit;
    public QSpacerItem horizontalSpacer;
    public QDateEdit dateEdit;
    public QPushButton dateOkButton;
    public QPushButton dateCancelButton;

    public Ui_CalendarW() { super(); }

    public void setupUi(QWidget CalendarW)
    {
        CalendarW.setObjectName("CalendarW");
        CalendarW.resize(new QSize(835, 366).expandedTo(CalendarW.minimumSizeHint()));
        verticalLayout = new QVBoxLayout(CalendarW);
        verticalLayout.setObjectName("verticalLayout");
        dateWidget = new QCalendarWidget(CalendarW);
        dateWidget.setObjectName("dateWidget");

        verticalLayout.addWidget(dateWidget);

        horizontalLayout = new QHBoxLayout();
        horizontalLayout.setObjectName("horizontalLayout");
        dateTextEdit = new QLineEdit(CalendarW);
        dateTextEdit.setObjectName("dateTextEdit");

        horizontalLayout.addWidget(dateTextEdit);

        horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout.addItem(horizontalSpacer);

        dateEdit = new QDateEdit(CalendarW);
        dateEdit.setObjectName("dateEdit");

        horizontalLayout.addWidget(dateEdit);

        dateOkButton = new QPushButton(CalendarW);
        dateOkButton.setObjectName("dateOkButton");

        horizontalLayout.addWidget(dateOkButton);

        dateCancelButton = new QPushButton(CalendarW);
        dateCancelButton.setObjectName("dateCancelButton");

        horizontalLayout.addWidget(dateCancelButton);


        verticalLayout.addLayout(horizontalLayout);

        retranslateUi(CalendarW);

        CalendarW.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget CalendarW)
    {
        CalendarW.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("CalendarW", "Form", null));
        dateOkButton.setText(com.trolltech.qt.core.QCoreApplication.translate("CalendarW", "Acceptar", null));
        dateCancelButton.setText(com.trolltech.qt.core.QCoreApplication.translate("CalendarW", "Cancelar", null));
    } // retranslateUi

}

