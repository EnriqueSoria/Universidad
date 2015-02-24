package seminari.notepad;

import com.trolltech.qt.core.QFile;
import com.trolltech.qt.core.QTextStream;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QCloseEvent;
import com.trolltech.qt.gui.QCursor;
import com.trolltech.qt.gui.QDialogButtonBox.StandardButton;
import com.trolltech.qt.gui.QFileDialog;
import com.trolltech.qt.gui.QIcon;
import com.trolltech.qt.gui.QMainWindow;
import com.trolltech.qt.gui.QMessageBox;
import com.trolltech.qt.gui.QPrinter;
import com.trolltech.qt.gui.QSyntaxHighlighter;
import com.trolltech.qt.gui.QTextCursor.MoveMode;
import com.trolltech.qt.gui.QTextCursor.MoveOperation;
import com.trolltech.qt.gui.QWidget;

public class FinestraPrincipal extends QMainWindow {

    Ui_FinestraPrincipal ui = new Ui_FinestraPrincipal();
    static String nom1 = "Enrique Soria Magraner", nom2 = "Javi Martinez Patiño";
    boolean pressed;
    int prevIndex; String prevInp;
    Calendar cal = new Calendar();
    
    int b1, b2, i1, i2, u1, u2;

    public static void main(String[] args) {
        QApplication.initialize(args);

        FinestraPrincipal testFinestraPrincipal = new FinestraPrincipal();
        testFinestraPrincipal.show();
        
        QApplication.exec();
    }

    public FinestraPrincipal() {
        ui.setupUi(this);
        setWindowTitle("Notepad#");
        setWindowIcon(new QIcon("src\\icons\\notepad#.png"));
        
        ui.textEdit.acceptRichText();
        
        // Cercar i reemplaçar
        amagaCerca();
        amagaReemplaza();
        ui.action_Cercar.triggered.connect(this, "showCerca()");
        ui.action_Reempla_ar.triggered.connect(this, "showReemplaza()");
        prevIndex = 0; prevInp = "";

        // Arxiu
        ui.actionNou.triggered.connect(this, "nou()");
        ui.action_Obrir.triggered.connect(this, "obrir()");
        ui.actionGuardar.triggered.connect(this, "guardar()");
        ui.actionGuardar_com.triggered.connect(this, "guardarCom()");
        ui.action_Sortir.triggered.connect(this, "sortir()");
        ui.action_Imprimir.triggered.connect(this, "imprimir()");
        ui.actionNombre_de_car_cters.triggered.connect(this, "numChars()");
        ui.actionNombre_de_paraules.triggered.connect(this, "numParaules()");
        
        // Editar
        ui.action_Retallar.triggered.connect(this, "retallar()");
        ui.action_Copiar.triggered.connect(this, "copiar()");
        ui.action_Pegar.triggered.connect(this, "pegar()");
        ui.action_Desfer.triggered.connect(this, "desfer()");
        ui.action_Refer.triggered.connect(this, "refer()");
        ui.action_Selecciona_ho_tot.triggered.connect(this, "seleccionaTot()");
        ui.action_Insertar_data.triggered.connect(this, "showCalendar()");

        // Format
        ui.action_B.triggered.connect(this, "negreta()");
        ui.action_I.triggered.connect(this, "italica()");
        ui.action_U.triggered.connect(this, "subratllat()");
        ui.action_Augmentar_tamany.triggered.connect(this, "zoomIn()");
        ui.action_Reduir_tamany.triggered.connect(this, "zoomOut()");
        
        // Sobre
        ui.action_Sobre.triggered.connect(this, "about()");
        
        // JavaMode
        ui.textEdit.textChanged.connect(this, "javaMode()");
        ui.action_Editor_de_Java.toggled.connect(this, "changeJavaMode()");
        
        ui.barraBusqueda.connectSlotsByName();       
    }

    public FinestraPrincipal(QWidget parent) {
        super(parent);
        ui.setupUi(this);
    }
    
    public void javaMode(){
    	if ( !ui.action_Editor_de_Java.isChecked() ){
    		new QSyntaxHighlighter(ui.textEdit.document()) {
				protected void highlightBlock(String text) {}
			};
    	} else {
    		new Highlighter(ui.textEdit.document());
    	}
	}
    
    public void changeJavaMode(){
    	if ( ui.action_Editor_de_Java.isChecked() ){
    		new QSyntaxHighlighter(ui.textEdit.document()) {
				protected void highlightBlock(String text) {}
			};
    	} else 
    		new Highlighter(ui.textEdit.document());
	}

    /********* FORMATO **********/
    
    public void zoomIn() { ui.textEdit.zoomIn(); }
    public void zoomOut(){ ui.textEdit.zoomOut(); }
    
    public void negreta(){
    	if ( ui.action_B.isChecked() )
    		ui.textEdit.setFontWeight(ui.textEdit.fontWeight()+20);
    	else
    		ui.textEdit.setFontWeight(ui.textEdit.fontWeight()-20);
    }
    
    public void italica(){
    	ui.textEdit.setFontItalic(!ui.textEdit.fontItalic());
    }
    
    public void subratllat(){
    	ui.textEdit.setFontUnderline(!ui.textEdit.fontUnderline());
    }
    
    public void imprimir(){
    	ui.textEdit.document().print(new QPrinter());
    }
    
    
    /********** Editar ***********/
    
    public void showCalendar(){
    	cal.show();
    	cal.ui.dateOkButton.clicked.connect(this, "insertData()");
    }
    
    public void insertData(){
    	ui.textEdit.insertPlainText( cal.getDataString() );
    }
    
    public void amagaCerca(){
    	ui.editBusqueda.hide();
        ui.botoBusqueda.hide();
        ui.botoCancelaBusqueda.hide();
        ui.etiquetaBusqueda.hide();
    }
    
    public void showCerca(){
    	ui.editBusqueda.show();
        ui.botoBusqueda.show();
        ui.botoCancelaBusqueda.show();
        ui.etiquetaBusqueda.show();
        ui.editBusqueda.setFocus();
    }
    
    public void amagaReemplaza(){
    	amagaCerca();
    	ui.editReemplaza.hide();
        ui.botoReemplaza.hide();
        ui.botoReemplazaTots.hide();
        ui.etiquetaReemplaza.hide();
    }
    
    public void showReemplaza(){
    	showCerca();
    	ui.editReemplaza.show();
        ui.botoReemplaza.show();
        ui.botoReemplazaTots.show();
        ui.etiquetaReemplaza.show();
    }
    
    
    /*********** Arxiu *************/
    
    public void numChars(){
    	int num = ui.textEdit.toPlainText().length();
    	QMessageBox qb = new QMessageBox(com.trolltech.qt.gui.QMessageBox.Icon.Information, tr("Nombre de caràcters"), tr("Hi ha un total de <b><i>" + num + "</i></b> caràcters") ); 
    	qb.show();
    }
    
    public void numParaules(){
    	int num;
    	if ( ui.textEdit.toPlainText().length()==0 )
    		num = 0;
    	else 
    		num = ui.textEdit.toPlainText().split(" ").length;
    	QMessageBox qb = new QMessageBox(com.trolltech.qt.gui.QMessageBox.Icon.Information, tr("Nombre de paraules"), tr("Hi ha un total de <b><i>" + num + "</i></b> paraules") ); 
    	qb.show();
    }
    
    public void nou(){
    	volGuardar();
    	ui.textEdit.clear();
    	ui.textEdit.document().setModified(false);
    }

    public void obrir(){
	    ui.statusbar.showMessage("Obrir", 2000);
		volGuardar();
		ui.textEdit.clear();
		String fileName = QFileDialog.getOpenFileName(this,tr("Obrir fitxer"), "C:/", new QFileDialog.Filter( tr("Fitxer de text (*.txt);;Fitxer de text enriquit (*.rtf);;Tots (*.*)")) );
		
		QFile file = new QFile(fileName);
        if (!file.open(new QFile.OpenMode(QFile.OpenModeFlag.ReadOnly, QFile.OpenModeFlag.Text))) {
            QMessageBox.warning(this, tr("Application"), String.format(tr("No s'ha pogut llegir el fitxer %1$s:\n%2$s."), fileName, file.errorString()));
            return;
        }

        QTextStream in = new QTextStream(file);
        QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
        ui.textEdit.setPlainText(in.readAll());
        QApplication.restoreOverrideCursor();

        //setCurrentFile(fileName);
        statusBar().showMessage(tr("File loaded"), 2000);
        ui.textEdit.setDocumentTitle(fileName);
    }
		
	public void guardar(){
		String nom = "";
    	if ( ui.textEdit.documentTitle().length() > 0 )
    		nom = ui.textEdit.documentTitle();
    	else{
    		nom = QFileDialog.getSaveFileName(this, tr("Obrir fitxer"), "C:/", new QFileDialog.Filter(tr("Fitxer de text (*.txt);;Fitxer de text enriquit (*.rtf);;Tots (*.*)")) );
        	if ( nom.length() == 0 )
        		return;
    	}
    	
    	QFile fitx = new QFile(nom);
    	if ( !fitx.open(new QFile.OpenMode(QFile.OpenModeFlag.WriteOnly, QFile.OpenModeFlag.Text)) ){
    		QMessageBox.warning(this, tr("Application"),
    				String.format(tr("El fitxer no es pot escriure %1$s:\n%2$s."),
    				nom, fitx.errorString()));
    		return;
    	}
    	ui.textEdit.setDocumentTitle(nom);
    	QTextStream out = new QTextStream(fitx);
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	out.writeString( ui.textEdit.toPlainText() );
    	QApplication.restoreOverrideCursor();
    	statusBar().showMessage(tr("Document guardat"), 2000);
    	fitx.close();
    	
    	ui.textEdit.document().setModified(false);
    	
    	return;
    		
    }
    
    public void guardarCom(){
    	String nom = QFileDialog.getSaveFileName(this, tr("Guardar fitxer"), "C:/", new QFileDialog.Filter(tr("Fitxer de text (*.txt);;Fitxer de text enriquit (*.rtf);;Tots (*.*)")) );
    	if ( nom.length() == 0 )
    		return;
    	QFile fitx = new QFile(nom);
    	if ( !fitx.open(new QFile.OpenMode(QFile.OpenModeFlag.WriteOnly, QFile.OpenModeFlag.Text)) ){
    		QMessageBox.warning(this, tr("Application"),
    				String.format(tr("El fitxer no es pot escriure %1$s:\n%2$s."),
    				nom, fitx.errorString()));
    		return;
    	}
    	ui.textEdit.setDocumentTitle(nom);
    	QTextStream out = new QTextStream(fitx);
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	out.writeString( ui.textEdit.toPlainText() );
    	QApplication.restoreOverrideCursor();
    	statusBar().showMessage(tr("Document guardat"), 2000);
    	fitx.close();
    	
    	ui.textEdit.document().setModified(false);
    	
    	return;
    }
    
    // BUSCAR
    public void on_botoBusqueda_clicked(){
    	ui.textEdit.setFocus();
    	
    	String inp = ui.editBusqueda.text();
    	String text = ui.textEdit.toPlainText();

    	QCursor prev = ui.textEdit.cursor();
    	ui.textEdit.moveCursor(MoveOperation.Start);
    	
    	if ( ui.textEdit.find(inp) ){
    		int a;			int index = 0;
    		ui.textEdit.moveCursor(MoveOperation.Start);
    		if ( !prevInp.equals(inp) ){
	    		a=0;
    		}
    		else{
    			for ( int x=0; x<prevIndex; x++ ){
    				ui.textEdit.moveCursor(MoveOperation.Right);
    			}
    			a = prevIndex;
    		}
	    	while ( index < inp.length() && a < text.length() ){
	    		if ( text.charAt(a) == inp.charAt(index) )	
	    				index++;
	    		else	index=0;
	    		a++;
	    		ui.textEdit.moveCursor(MoveOperation.Right);
	    	}
	    	if ( a < text.length() ){
		    	for ( int x=0; x<inp.length(); x++ ){
		    		ui.textEdit.moveCursor(MoveOperation.Left, MoveMode.KeepAnchor);
		    	}
		    		prevIndex = a; prevInp = inp;
	    	}
	    	else{	prevIndex = 0; prevInp = inp;}
    	} else {
    		ui.statusbar.showMessage("No s'han trobat resultats",2000);
    		ui.textEdit.setCursor(prev);
    	}
    	ui.textEdit.setFocus();
    }
    
    // REEMPLAZAR
    public void on_botoReemplaza_clicked(){
    	if ( ui.editBusqueda.text().equals ( ui.textEdit.textCursor().selectedText() ) ){
    		ui.textEdit.insertPlainText(ui.editReemplaza.text());
    	}
    }
    
    // REEMPLAZAR_TOT
    public void on_botoReemplazaTots_clicked(){
    	try{
    		int numIteraciones = 10000;
    		
    		for ( int a=0; a<numIteraciones; a++){
    			on_botoBusqueda_clicked();
    			on_botoReemplaza_clicked();
    		}
    	} catch (Exception e ){}
    	ui.statusbar.showMessage("Reemplaçat tot correctament",2000);
    }
    
    // BOTO CANCELAR
    public void on_botoCancelaBusqueda_clicked(){   amagaReemplaza();    }
    
    public void retallar()	{	ui.textEdit.cut();		}
    public void copiar()	{	ui.textEdit.copy();	}
    public void pegar()		{ 	ui.textEdit.paste();	}
    
    public void desfer()	{	ui.textEdit.undo();	}
    public void refer()		{	ui.textEdit.redo();	}
    
    public void seleccionaTot()	{	ui.textEdit.selectAll();	}

    public boolean volGuardar(){
    	if ( ui.textEdit.document().isModified() )
	    	if ( QMessageBox.question(this, "Guardar", "L'arxiu ha estat modificat. Vols guardar-lo?",
	    			QMessageBox.StandardButton.Yes,QMessageBox.StandardButton.No) 
	    			== StandardButton.Yes.value() )
	    		guardar();
    	return true;
    }
    
    public void about(){
    	QMessageBox.about(this,
                tr("Sobre el Notepad#"),
                tr("El <b>Notepad<i>#</i></b> ha estat desenvolupat com una solució lliure al bloc de notes del Windows.<p><p>" +
                		"Ha estat creat pels alumnes de 2n d'Eng.Informàtica: <br><b>- "+nom1+"</b> <br><b>- "+nom2+"</b>." +
                		"<p><br> <br><i><b>Llicències</b></i><br>El codi necessari per a colorejar la sintaxi de Java ha estat copiat dels codis d'exemple del QtJambi" +
                		", que es troben baix llicència GNU GPL 3.0"
                		));
    }
    
    public void closeEvent(QCloseEvent event)
    {
        if (volGuardar()) {
            event.accept();
        } else {
            event.ignore();
        }
    }
    
    public void sortir(){
    	volGuardar();
    	this.close();
    }
}
