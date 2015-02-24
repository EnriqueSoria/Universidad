/********************************************************************************
** Form generated from reading ui file 'FinestraPrincipal.jui'
**
** Created: ju. 25. abr. 19:09:19 2013
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package seminari.notepad;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_FinestraPrincipal implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QAction actionNou;
    public QAction actionGuardar;
    public QAction actionGuardar_com;
    public QAction action_Obrir;
    public QAction action_Retallar;
    public QAction action_Copiar;
    public QAction action_Pegar;
    public QAction action_Cercar;
    public QAction action_Reempla_ar;
    public QAction action_Sobre;
    public QAction action_Desfer;
    public QAction action_Refer;
    public QAction action_Selecciona_ho_tot;
    public QAction action_Sortir;
    public QAction action_Editor_de_Java;
    public QAction action_Insertar_data;
    public QAction action_Imprimir;
    public QAction action_B;
    public QAction action_I;
    public QAction action_U;
    public QAction action_Augmentar_tamany;
    public QAction action_Reduir_tamany;
    public QAction actionNombre_de_paraules;
    public QAction actionNombre_de_car_cters;
    public QWidget centralwidget;
    public QVBoxLayout verticalLayout;
    public QTextEdit textEdit;
    public QHBoxLayout barraBusqueda;
    public QLabel etiquetaBusqueda;
    public QLineEdit editBusqueda;
    public QPushButton botoBusqueda;
    public QPushButton botoCancelaBusqueda;
    public QHBoxLayout barraReemplaza;
    public QLabel etiquetaReemplaza;
    public QLineEdit editReemplaza;
    public QPushButton botoReemplaza;
    public QPushButton botoReemplazaTots;
    public QMenuBar menubar;
    public QMenu menuArchivo;
    public QMenu menuEditar;
    public QMenu menuAcerca_de;
    public QMenu menuFormato;
    public QStatusBar statusbar;
    public QToolBar toolBar;

    public Ui_FinestraPrincipal() { super(); }

    public void setupUi(QMainWindow FinestraPrincipal)
    {
        FinestraPrincipal.setObjectName("FinestraPrincipal");
        FinestraPrincipal.resize(new QSize(810, 471).expandedTo(FinestraPrincipal.minimumSizeHint()));
        actionNou = new QAction(FinestraPrincipal);
        actionNou.setObjectName("actionNou");
        actionNou.setIcon(new QIcon(new QPixmap("classpath:src/icons/New_48x48.png")));
        actionGuardar = new QAction(FinestraPrincipal);
        actionGuardar.setObjectName("actionGuardar");
        actionGuardar.setIcon(new QIcon(new QPixmap("classpath:src/icons/Save_48x48.png")));
        actionGuardar_com = new QAction(FinestraPrincipal);
        actionGuardar_com.setObjectName("actionGuardar_com");
        actionGuardar_com.setIcon(new QIcon(new QPixmap("classpath:src/icons/Save_48x48.png")));
        action_Obrir = new QAction(FinestraPrincipal);
        action_Obrir.setObjectName("action_Obrir");
        action_Obrir.setIcon(new QIcon(new QPixmap("classpath:src/icons/Open_48x48.png")));
        action_Retallar = new QAction(FinestraPrincipal);
        action_Retallar.setObjectName("action_Retallar");
        action_Retallar.setIcon(new QIcon(new QPixmap("classpath:src/icons/Cut_48x48.png")));
        action_Copiar = new QAction(FinestraPrincipal);
        action_Copiar.setObjectName("action_Copiar");
        action_Copiar.setIcon(new QIcon(new QPixmap("classpath:src/icons/Copy_48x48.png")));
        action_Pegar = new QAction(FinestraPrincipal);
        action_Pegar.setObjectName("action_Pegar");
        action_Pegar.setIcon(new QIcon(new QPixmap("classpath:src/icons/Paste_48x48.png")));
        action_Cercar = new QAction(FinestraPrincipal);
        action_Cercar.setObjectName("action_Cercar");
        action_Cercar.setIcon(new QIcon(new QPixmap("classpath:src/icons/Search_48x48.png")));
        action_Reempla_ar = new QAction(FinestraPrincipal);
        action_Reempla_ar.setObjectName("action_Reempla_ar");
        action_Reempla_ar.setIcon(new QIcon(new QPixmap("classpath:src/icons/Preview_48x48.png")));
        action_Sobre = new QAction(FinestraPrincipal);
        action_Sobre.setObjectName("action_Sobre");
        action_Sobre.setIcon(new QIcon(new QPixmap("classpath:src/icons/Help_48x48.png")));
        action_Desfer = new QAction(FinestraPrincipal);
        action_Desfer.setObjectName("action_Desfer");
        action_Desfer.setIcon(new QIcon(new QPixmap("classpath:src/icons/Undo_48x48.png")));
        action_Refer = new QAction(FinestraPrincipal);
        action_Refer.setObjectName("action_Refer");
        action_Refer.setIcon(new QIcon(new QPixmap("classpath:src/icons/Redo_48x48.png")));
        action_Selecciona_ho_tot = new QAction(FinestraPrincipal);
        action_Selecciona_ho_tot.setObjectName("action_Selecciona_ho_tot");
        action_Sortir = new QAction(FinestraPrincipal);
        action_Sortir.setObjectName("action_Sortir");
        action_Editor_de_Java = new QAction(FinestraPrincipal);
        action_Editor_de_Java.setObjectName("action_Editor_de_Java");
        action_Editor_de_Java.setCheckable(true);
        action_Editor_de_Java.setIcon(new QIcon(new QPixmap("classpath:src/icons/Edit_48x48.png")));
        action_Insertar_data = new QAction(FinestraPrincipal);
        action_Insertar_data.setObjectName("action_Insertar_data");
        action_Insertar_data.setIcon(new QIcon(new QPixmap("classpath:src/icons/Calendar_48x48.png")));
        action_Imprimir = new QAction(FinestraPrincipal);
        action_Imprimir.setObjectName("action_Imprimir");
        action_Imprimir.setIcon(new QIcon(new QPixmap("classpath:src/icons/Print_48x48.png")));
        action_B = new QAction(FinestraPrincipal);
        action_B.setObjectName("action_B");
        action_B.setCheckable(true);
        action_B.setIcon(new QIcon(new QPixmap("classpath:src/icons/bold.png")));
        action_I = new QAction(FinestraPrincipal);
        action_I.setObjectName("action_I");
        action_I.setCheckable(true);
        action_I.setIcon(new QIcon(new QPixmap("classpath:src/icons/italic.png")));
        action_U = new QAction(FinestraPrincipal);
        action_U.setObjectName("action_U");
        action_U.setCheckable(true);
        action_U.setIcon(new QIcon(new QPixmap("classpath:src/icons/underlined.png")));
        action_Augmentar_tamany = new QAction(FinestraPrincipal);
        action_Augmentar_tamany.setObjectName("action_Augmentar_tamany");
        action_Augmentar_tamany.setIcon(new QIcon(new QPixmap("classpath:src/icons/Zoom In_48x48.png")));
        action_Reduir_tamany = new QAction(FinestraPrincipal);
        action_Reduir_tamany.setObjectName("action_Reduir_tamany");
        action_Reduir_tamany.setIcon(new QIcon(new QPixmap("classpath:src/icons/Zoom Out_48x48.png")));
        actionNombre_de_paraules = new QAction(FinestraPrincipal);
        actionNombre_de_paraules.setObjectName("actionNombre_de_paraules");
        actionNombre_de_car_cters = new QAction(FinestraPrincipal);
        actionNombre_de_car_cters.setObjectName("actionNombre_de_car_cters");
        centralwidget = new QWidget(FinestraPrincipal);
        centralwidget.setObjectName("centralwidget");
        verticalLayout = new QVBoxLayout(centralwidget);
        verticalLayout.setObjectName("verticalLayout");
        textEdit = new QTextEdit(centralwidget);
        textEdit.setObjectName("textEdit");

        verticalLayout.addWidget(textEdit);

        barraBusqueda = new QHBoxLayout();
        barraBusqueda.setObjectName("barraBusqueda");
        etiquetaBusqueda = new QLabel(centralwidget);
        etiquetaBusqueda.setObjectName("etiquetaBusqueda");

        barraBusqueda.addWidget(etiquetaBusqueda);

        editBusqueda = new QLineEdit(centralwidget);
        editBusqueda.setObjectName("editBusqueda");

        barraBusqueda.addWidget(editBusqueda);

        botoBusqueda = new QPushButton(centralwidget);
        botoBusqueda.setObjectName("botoBusqueda");

        barraBusqueda.addWidget(botoBusqueda);

        botoCancelaBusqueda = new QPushButton(centralwidget);
        botoCancelaBusqueda.setObjectName("botoCancelaBusqueda");

        barraBusqueda.addWidget(botoCancelaBusqueda);


        verticalLayout.addLayout(barraBusqueda);

        barraReemplaza = new QHBoxLayout();
        barraReemplaza.setObjectName("barraReemplaza");
        etiquetaReemplaza = new QLabel(centralwidget);
        etiquetaReemplaza.setObjectName("etiquetaReemplaza");

        barraReemplaza.addWidget(etiquetaReemplaza);

        editReemplaza = new QLineEdit(centralwidget);
        editReemplaza.setObjectName("editReemplaza");

        barraReemplaza.addWidget(editReemplaza);

        botoReemplaza = new QPushButton(centralwidget);
        botoReemplaza.setObjectName("botoReemplaza");

        barraReemplaza.addWidget(botoReemplaza);

        botoReemplazaTots = new QPushButton(centralwidget);
        botoReemplazaTots.setObjectName("botoReemplazaTots");

        barraReemplaza.addWidget(botoReemplazaTots);


        verticalLayout.addLayout(barraReemplaza);

        FinestraPrincipal.setCentralWidget(centralwidget);
        menubar = new QMenuBar(FinestraPrincipal);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 810, 21));
        menuArchivo = new QMenu(menubar);
        menuArchivo.setObjectName("menuArchivo");
        menuEditar = new QMenu(menubar);
        menuEditar.setObjectName("menuEditar");
        menuAcerca_de = new QMenu(menubar);
        menuAcerca_de.setObjectName("menuAcerca_de");
        menuFormato = new QMenu(menubar);
        menuFormato.setObjectName("menuFormato");
        FinestraPrincipal.setMenuBar(menubar);
        statusbar = new QStatusBar(FinestraPrincipal);
        statusbar.setObjectName("statusbar");
        FinestraPrincipal.setStatusBar(statusbar);
        toolBar = new QToolBar(FinestraPrincipal);
        toolBar.setObjectName("toolBar");
        FinestraPrincipal.addToolBar(com.trolltech.qt.core.Qt.ToolBarArea.TopToolBarArea, toolBar);

        menubar.addAction(menuArchivo.menuAction());
        menubar.addAction(menuEditar.menuAction());
        menubar.addAction(menuFormato.menuAction());
        menubar.addAction(menuAcerca_de.menuAction());
        menuArchivo.addAction(actionNou);
        menuArchivo.addAction(action_Obrir);
        menuArchivo.addAction(actionGuardar);
        menuArchivo.addAction(actionGuardar_com);
        menuArchivo.addSeparator();
        menuArchivo.addAction(action_Imprimir);
        menuArchivo.addSeparator();
        menuArchivo.addAction(actionNombre_de_paraules);
        menuArchivo.addAction(actionNombre_de_car_cters);
        menuArchivo.addSeparator();
        menuArchivo.addAction(action_Sortir);
        menuEditar.addAction(action_Desfer);
        menuEditar.addAction(action_Refer);
        menuEditar.addAction(action_Retallar);
        menuEditar.addAction(action_Copiar);
        menuEditar.addAction(action_Pegar);
        menuEditar.addSeparator();
        menuEditar.addAction(action_Cercar);
        menuEditar.addAction(action_Reempla_ar);
        menuEditar.addAction(action_Selecciona_ho_tot);
        menuEditar.addSeparator();
        menuEditar.addAction(action_Insertar_data);
        menuAcerca_de.addAction(action_Sobre);
        menuFormato.addAction(action_B);
        menuFormato.addAction(action_I);
        menuFormato.addAction(action_U);
        menuFormato.addSeparator();
        menuFormato.addAction(action_Augmentar_tamany);
        menuFormato.addAction(action_Reduir_tamany);
        menuFormato.addSeparator();
        menuFormato.addAction(action_Editor_de_Java);
        toolBar.addAction(actionNou);
        toolBar.addAction(action_Obrir);
        toolBar.addAction(actionGuardar);
        toolBar.addAction(action_Imprimir);
        toolBar.addSeparator();
        toolBar.addAction(action_Retallar);
        toolBar.addAction(action_Copiar);
        toolBar.addAction(action_Pegar);
        toolBar.addAction(action_Desfer);
        toolBar.addAction(action_Refer);
        toolBar.addSeparator();
        toolBar.addAction(action_B);
        toolBar.addAction(action_I);
        toolBar.addAction(action_U);
        toolBar.addAction(action_Augmentar_tamany);
        toolBar.addAction(action_Reduir_tamany);
        toolBar.addSeparator();
        toolBar.addAction(action_Cercar);
        toolBar.addAction(action_Reempla_ar);
        toolBar.addSeparator();
        toolBar.addAction(action_Editor_de_Java);
        toolBar.addAction(action_Insertar_data);
        retranslateUi(FinestraPrincipal);

        FinestraPrincipal.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow FinestraPrincipal)
    {
        FinestraPrincipal.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "MainWindow", null));
        actionNou.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&Nou", null));
        actionNou.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Nou document", null));
        actionNou.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Ctrl+N", null));
        actionGuardar.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&Guardar", null));
        actionGuardar.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Guardar el archivo", null));
        actionGuardar.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Ctrl+S", null));
        actionGuardar_com.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Guardar com...", null));
        actionGuardar_com.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Guarda l'arxiu amb un altre nom", null));
        actionGuardar_com.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Ctrl+Shift+S", null));
        action_Obrir.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&Obrir", null));
        action_Obrir.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Obrir un arxiu", null));
        action_Obrir.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Ctrl+O", null));
        action_Retallar.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Re&tallar", null));
        action_Retallar.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Retallar el text seleccionat", null));
        action_Retallar.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Ctrl+X", null));
        action_Copiar.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&C&opiar", null));
        action_Copiar.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Copiar el text seleccionat", null));
        action_Copiar.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Ctrl+C", null));
        action_Pegar.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&Pegar", null));
        action_Pegar.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Pegar el text que est\u00e0 en el porta-retalls", null));
        action_Pegar.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Ctrl+V", null));
        action_Cercar.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&Cercar", null));
        action_Cercar.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Cercar al text", null));
        action_Cercar.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Ctrl+F", null));
        action_Reempla_ar.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&R&eempla\u00e7ar", null));
        action_Reempla_ar.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Reempla\u00e7a un text per un altre", null));
        action_Reempla_ar.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Ctrl+Shift+F", null));
        action_Sobre.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&Sobre...", null));
        action_Sobre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Informaci\u00f3 sobre el programa", null));
        action_Desfer.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&Desfer", null));
        action_Desfer.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Desfer l'\u00faltima acci\u00f3", null));
        action_Desfer.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Ctrl+Z", null));
        action_Refer.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&Refer", null));
        action_Refer.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Refer l'\u00faltima acci\u00f3 desfeta", null));
        action_Refer.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Ctrl+Y", null));
        action_Selecciona_ho_tot.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&Selecciona-ho tot", null));
        action_Selecciona_ho_tot.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Selecciona-ho tot", null));
        action_Selecciona_ho_tot.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Ctrl+A", null));
        action_Sortir.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&Sortir", null));
        action_Sortir.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Sortir del programa", null));
        action_Editor_de_Java.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Editor de &Java", null));
        action_Editor_de_Java.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Activa el mode editor de Java", null));
        action_Editor_de_Java.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Ctrl+J", null));
        action_Insertar_data.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&Insertar data", null));
        action_Insertar_data.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Insertar la data d'avui", null));
        action_Insertar_data.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Ctrl+D", null));
        action_Imprimir.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&Imprimir", null));
        action_Imprimir.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Imprimir el document", null));
        action_Imprimir.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Ctrl+P", null));
        action_B.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&Negreta", null));
        action_B.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-weight:600;\">Negreta</span></p></body></html>", null));
        action_B.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Ctrl+B", null));
        action_I.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&It\u00e0lica", null));
        action_I.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-style:italic;\">Italica</span></p></body></html>", null));
        action_I.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Ctrl+I", null));
        action_U.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&Subratllat", null));
        action_U.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" text-decoration: underline;\">Subratllat</span></p></body></html>", null));
        action_U.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Ctrl+U", null));
        action_Augmentar_tamany.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&Augmentar tamany", null));
        action_Augmentar_tamany.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Augmenta el tamany del text", null));
        action_Augmentar_tamany.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Ctrl++", null));
        action_Reduir_tamany.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&Redu\u00efr tamany", null));
        action_Reduir_tamany.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Redu\u00efr el tamany del text", null));
        action_Reduir_tamany.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Ctrl+-", null));
        actionNombre_de_paraules.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Nombre de &paraules", null));
        actionNombre_de_car_cters.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Nombre de &car\u00e0cters", null));
        etiquetaBusqueda.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Cerca        ", null));
        botoBusqueda.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Buscar", null));
        botoCancelaBusqueda.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Cancelar", null));
        etiquetaReemplaza.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Reempla\u00e7a", null));
        botoReemplaza.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Reempla\u00e7ar", null));
        botoReemplazaTots.setText(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "Reemp. tots", null));
        menuArchivo.setTitle(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&Arxiu", null));
        menuEditar.setTitle(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&Editar", null));
        menuAcerca_de.setTitle(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&Sobre", null));
        menuFormato.setTitle(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "&Format", null));
        toolBar.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("FinestraPrincipal", "toolBar", null));
    } // retranslateUi

}

