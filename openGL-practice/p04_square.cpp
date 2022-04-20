#include<GL/glut.h>
#include <gl/GL.h>
#include<gl/GLU.h>

void MyDisplay()
{
	glClear(GL_COLOR_BUFFER_BIT);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();

	glBegin(GL_LINES);
	glColor3f(1, 0, 0); // X
	glVertex3f(-1, 0, 0); glVertex3f(1, 0, 0);
	glColor3f(0, 1, 0); // Y
	glVertex3f(0, -1, 0); glVertex3f(0, 1, 0);
	glColor3f(0, 0, 1); // Z
	glVertex3f(0, 0, -1); glVertex3f(0, 0, 1);
	glEnd();

	//glRotatef(45, 0.0, 0.0, 1.0);
	//glScalef(2.0, 2.0, 1.0);
	//glTranslatef(0.3, 0.0, 0.0);
	
	//glRotatef(45, 0.0, 0.0, 1.0);
	//glTranslatef(0.4, -0.4, 0.0);
	//glScalef(2.0, 2.0, 0.0);

	//glScalef(2.0, 2.0, 0.0);
	//glTranslatef(0.3, 0.3, 0.0);
	//glRotatef(45, 0.0, 0.0, 1.0);

	//glBegin(GL_POLYGON);
	//glVertex3f(-0.1, -0.1, 0.0);
	//glVertex3f(-0.1, 0.1, 0.0);
	//glVertex3f(0.1, 0.1, 0.0);
	//glVertex3f(0.1, -0.1, 0.0);
	//glEnd();

	//glPushMatrix();
	//glScalef(1.5, 1.5, 0.0);
	//glRotatef(45, 0.0, 0.0, 1.0);
	//glTranslatef(0.5, 0.1, 0.0);

	//glBegin(GL_POLYGON);
	//glVertex3f(-0.1, -0.1, 0.0);
	//glVertex3f(-0.1, 0.1, 0.0);
	//glVertex3f(0.1, 0.1, 0.0);
	//glVertex3f(0.1, -0.1, 0.0);
	//glEnd();
	//glPopMatrix();

	////glLoadIdentity();
	//glPushMatrix();
	//glRotatef(45, 0.0, 0.0, 1.0);
	//glTranslatef(-0.5, 0.5, 0.0);

	//glBegin(GL_POLYGON);
	//glVertex3f(-0.1, -0.1, 0.0);
	//glVertex3f(-0.1, 0.1, 0.0);
	//glVertex3f(0.1, 0.1, 0.0);
	//glVertex3f(0.1, -0.1, 0.0);
	//glEnd();
	//glPopMatrix();


	//glutWireTeapot(0.25);
	//glEnd();

	//glPushMatrix();
	//	glTranslatef(1.5, 1.5, 0.0);
	//	glutWireTeapot(0.25);
	//	glEnd();

	//	glPushMatrix();
	//		glTranslatef(-1.5, -3.0, 0.0);
	//		glutWireTeapot(0.25);
	//		glEnd();
	//	glPopMatrix();

	//	glTranslatef(2.0, -0.3, 0.0);
	//	glScalef(1.5, 1.5, 0.0);
	//	glRotatef(45, 0.0, 0.0, 1.0);
	//	glutWireTeapot(0.25);
	//	glEnd();
	//glPopMatrix();


	glColor3f(1.0, 0.0, 0.0);

	glPushMatrix();
	glScalef(1.5, 1.0, 1.0);
	glutSolidCube(0.5);
	glPopMatrix();

	glColor3f(0.0, 0.0, 1.0);

	glPushMatrix();
	glTranslatef(-0.6, 0, 0);
	glutSolidCube(0.5);

	glTranslatef(1.2, 0.0, 0.0);
	glutSolidCube(0.5);
	glPopMatrix();

	glColor3f(1.0, 1.0, 0.0);

	glPushMatrix();
	glRotatef(-90, 1.0, 0.0, 0.0);
	glScalef(2.0, 1.0, 1.0);
	glTranslatef(-0.6, 0.5, 0.0);
	glutSolidCone(0.1, 0.3, 36, 10);
	glPopMatrix();

	glPushMatrix();
	glRotatef(90, 1.0, 0.0, 0.0);
	glTranslatef(0.6, 0.5, 0.0);
	glutSolidCone(0.1, 0.1, 36, 10);
	glPopMatrix();

	glFlush();
}

int main(int argc, char** argv)
{
	glutInit(&argc, argv);
	glutInitWindowSize(700, 700);
	glutCreateWindow("OpenGL Example");

	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	//glOrtho(-6.0, 6.0, -6.0, 6.0, -1.0, 1.0);

	glClearColor(1.0, 1.0, 1.0, 1.0);
	glutDisplayFunc(MyDisplay);
	glutMainLoop();
	return 0;
}