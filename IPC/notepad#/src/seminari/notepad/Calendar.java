package seminari.notepad;

import com.trolltech.qt.core.QDate;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QWidget;

public class Calendar extends QWidget {

    Ui_CalendarW ui = new Ui_CalendarW();
    boolean cancel = false;
    
    String dia[] = {"","Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissapte", "Diumenge"};
    String mes[] = {"","Gener","Febrer","Març","Abril","Març","Juny","Juliol","Agost","Septembre","Octubre","Novembre","Desembre"};

    public static void main(String[] args) {
        QApplication.initialize(args);
        Calendar testCalendarW = new Calendar();
        testCalendarW.show();
        
        QApplication.exec();
    }

    public Calendar() {
        ui.setupUi(this);
        
        setWindowTitle("Insertar data del calendari");
        setWindowIconText("\\src\\icons\\Calendar_48x48.png");
        
        ui.dateEdit.dateChanged.connect(this, "spinDataCanviat()");
        ui.dateWidget.selectionChanged.connect(this, "widgetDataCanviat()");
        
        ui.dateOkButton.clicked.connect(this, "ok()");
        ui.dateCancelButton.clicked.connect(this, "cancel()");
        
        actualitzarData(true, ui.dateWidget.selectedDate());
    }

    public Calendar(QWidget parent) {
        super(parent);
        ui.setupUi(this);
    }
    
    public void widgetDataCanviat(){
    	QDate r = ui.dateWidget.selectedDate();
    	
    	actualitzarData(true, r);
    }
    
    public void spinDataCanviat(){
    	QDate r = ui.dateEdit.date();
    	
    	actualitzarData(false, r);
    }
    
    public void actualitzarData( boolean widget, QDate data ){
    	if ( !widget ) 	ui.dateWidget.setSelectedDate(data);
    	else			ui.dateEdit.setDate(data);
    	
    	String 	dd = dia[data.dayOfWeek()] + " " + data.day(),
    			mm = mes[data.month()].toLowerCase(),
    			aa = data.year()+"";
    	ui.dateTextEdit.setText( dd + (mm.charAt(0)=='a'||mm.charAt(0)=='o'?" d'":" de ") + mm + " del " + aa );
    }
    
    public int[] getData(){
    	int[] r = {ui.dateWidget.selectedDate().day(),ui.dateWidget.selectedDate().month(),ui.dateWidget.selectedDate().year()};
    	return r;
    }
    
    public String getDataString(){
    	return ui.dateTextEdit.text();
    }
    
    public void ok(){
    	close();
    }
    
    public void cancel(){
    	cancel = true;
    	close();
    }
}
