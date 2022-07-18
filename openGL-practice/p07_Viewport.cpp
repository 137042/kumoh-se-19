#include<GL/glut.h>
#include <gl/GL.h>
#include<gl/GLU.h>

GLint winWidth = 700;
GLint winHeight = 700;

void MyDisplay()
{
	glClear(GL_COLOR_BUFFER_BIT);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	
	//glViewport(200, 200, 400, 300);
	//glClearColor(1, 1, 1, 0);
	//gluLookAt(0, 1, 0, 0, 0, 0, 1, 0, 0);
	//glColor3f(1.0, 0.0, 0.0);
	//glutWireTeapot(1.0);

	glViewport(0, 0, winWidth / 2, winHeight / 2);
	glPushMatrix();
		gluLookAt(0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
		glColor3f(1.0, 0.0, 0.0);
		glutWireTeapot(0.5);
	glPopMatrix();

	glViewport(winWidth / 2, 0, winWidth / 2, winHeight / 2);
	glPushMatrix();
		gluLookAt(1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
		glColor3f(0.0, 1.0, 0.0);
		glutWireTeapot(0.5);
	glPopMatrix();

	glViewport(0, winHeight / 2, winWidth / 2, winHeight / 2);
	glPushMatrix();
		gluLookAt(0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0);
		glColor3f(0.0, 0.0, 1.0);
		glutWireTeapot(0.5);
	glPopMatrix();

	glViewport(winWidth / 2, winHeight / 2, winWidth / 2, winHeight / 2);
	glPushMatrix();
		gluLookAt(1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
		glColor3f(0.5, 0.0, 0.5);
		glutWireTeapot(0.5);
	glPopMatrix();

	glFlush();
}


void MyReshape(int width, int height)
{
	winWidth = width;
	winHeight = height;
}


int main(int argc, char** argv)
{
	glutInit(&argc, argv);
	glutInitWindowSize(700, 700);
	glutCreateWindow("OpenGL Drawing Example");

	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	glOrtho(-1.0, 1.0, -1.0, 1.0, -1.0, 30.0);
	glutReshapeFunc(MyReshape);
	glutDisplayFunc(MyDisplay);
	glutMainLoop();

	return 0;
}
