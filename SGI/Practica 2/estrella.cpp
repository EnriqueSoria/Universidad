#include <iostream>
#include <cmath>
#include <gl\glut.h>

//funcion que atiende al evento de dibujar (cada frame)
GLuint idLista;

static const int numCoord = 8;
static const GLfloat coordenadas[numCoord][3]	= 
{
	{0.0,1,0.0},
	{0.0,0.7,0.0},
	{1*cos(3.1415926/2+4*3.1415926/3),1*sin(3.1415926/2+4*3.1415926/3),0.0},
	{0.7*cos(3.1415926/2+4*3.1415926/3),0.7*sin(3.1415926/2+4*3.1415926/3),0.0},
	{1*cos(3.1415926/2+2*3.1415926/3),1*sin(3.1415926/2+2*3.1415926/3),0.0},
	{0.7*cos(3.1415926/2+2*3.1415926/3),0.7*sin(3.1415926/2+2*3.1415926/3),0.0},
	{0.0,1,0.0},
	{0.0,0.7,0.0},
};
static const GLfloat coord2[numCoord][3] = 
{
	{0.0,-1,0.0}, 
	{0.0,-0.7,0.0}, 
	{1*cos(3.1415926/2+5*3.1415926/3),1*sin(3.1415926/2+5*3.1415926/3),0.0},
	{0.7*cos(3.1415926/2+5*3.1415926/3),0.7*sin(3.1415926/2+5*3.1415926/3),0.0},
	{1*cos(3.1415926/2+1*3.1415926/3),1*sin(3.1415926/2+1*3.1415926/3),0.0},
	{0.7*cos(3.1415926/2+1*3.1415926/3),0.7*sin(3.1415926/2+1*3.1415926/3),0.0},
	{0.0,-1,0.0},
	{0.0,-0.7,0.0}
};


void myInit(){
	// Pedir el ide de la lista
	idLista = glGenLists(1);

	// Crear la lista
	glNewList( idLista, GL_COMPILE );
		glPushAttrib( GL_CURRENT_BIT );
		glPointSize( 20 );

		// Dibujamos el triangula
		glBegin(GL_TRIANGLE_STRIP);
		glColor3f(0.0, 0.0, 0.3);
			for(int i=0; i<numCoord; i++){
				GLfloat x = coordenadas[ i ][0];
				GLfloat y = coordenadas[ i ][1];
				glVertex2f(x, y);
			}
		glEnd();

		// Dibujamos el triangula
		glBegin(GL_TRIANGLE_STRIP);
		glColor3f(0.0, 0.0, 0.3);
			for(int i=0; i<numCoord; i++){
				GLfloat x = coord2[ i ][0];
				GLfloat y = coord2[ i ][1];
				glVertex2f(x, y);
			}
		glEnd();

	glEndList();
}


void display()

{
	// Borrar la pantalla
	glClearColor(1.0, 1.0, 1.0, 1.0);
	glClear( GL_COLOR_BUFFER_BIT );

	// Cambiar el tamaño del punto
	glPointSize( 50 );

	// Dibujar un triangulo
	glCallList( idLista );

	
	glCallList( idLista );

	// Descargar todas las operaciones pendientes
	glFlush();
}

void reshape(GLint w, GLint h)
{

}

void main(int argc, char** argv)
{
	 glutInit(&argc, argv);
	 glutInitDisplayMode(GLUT_SINGLE|GLUT_RGB);
	 glutInitWindowSize(400,400);
	 glutCreateWindow("Estrella de David");
	 glutDisplayFunc(display);
	 glutReshapeFunc(reshape);
	 myInit();
	 glutMainLoop();
}