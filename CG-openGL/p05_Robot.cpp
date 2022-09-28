#include <math.h>
using namespace std;

#include<GL/glut.h>
#include <gl/GL.h>
#include<gl/GLU.h>

int time = 0;

GLfloat headAngle = 0.0f;
GLfloat armAngleL = 0.0f;
GLfloat armAngleR = 0.0f;
GLfloat legAngleL = 0.0f;
GLfloat legAngleR = 0.0f;

void MyDisplay()
{
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();

	glBegin(GL_LINES);
	glColor3f(1, 0, 0); // X
	glVertex3f(-6, 0, 0); glVertex3f(6, 0, 0);
	glColor3f(0, 1, 0); // Y
	glVertex3f(0, -6, 0); glVertex3f(0, 6, 0);
	glColor3f(0, 0, 1); // Z
	glVertex3f(0, 0, -6); glVertex3f(0, 0, 6);
	glEnd();

	glPushMatrix();

		// ¸Ó¸®
		glColor3f(1.0, 0.0, 0.0);
		glPushMatrix();
		glRotatef(headAngle, 0.0f, 0.0f, 1.0f);
			glTranslatef(0.0, 2.8, 0.0);
			glRotatef(90, 0.0, 1.0, 0.0);
			glutSolidTeapot(0.8);
		glPopMatrix();

		// ¸ö
		glColor3f(0.0, 0.0, 1.0);
		glPushMatrix();
			glTranslatef(0.0, 1.0, 0.0);
			glutSolidCube(2.0);
		glPopMatrix();

		// ¿ÞÆÈ
		glColor3f(1.0, 1.0, 0.0);
		glPushMatrix();
			glRotatef(armAngleL, 1.0f, 0.0f, 0.0f);
			glTranslatef(-1.5, 0.0, 0.0);
			glScalef(1.0, 4.0, 1.0);
			glutSolidCube(0.5);

			// ¿Þ¼Õ
			glColor3f(0.0, 0.0, 0.0);
			glPushMatrix();
				glScalef(1.0, 0.25, 1.0);
				glTranslatef(0.0, -1.3, 0.0);
				glutSolidSphere(0.25, 12, 12);
			glPopMatrix();
		glPopMatrix();
		
		// ¿À¸¥ÆÈ
		glColor3f(0.0, 1.0, 0.0);
		glPushMatrix();
			glRotatef(armAngleR, 1.0f, 0.0f, 0.0f);
			glTranslatef(1.5, 0.0, 0.0);
			glScalef(1.0, 4.0, 1.0);
			glutSolidCube(0.5);

			// ¿À¸¥¼Õ
			glColor3f(0.0, 0.0, 0.0);
			glPushMatrix();
				glScalef(1.0, 0.25, 1.0);
				glTranslatef(0.0, -1.3, 0.0);
				glutSolidSphere(0.25, 12, 12);
			glPopMatrix();
		glPopMatrix();

		// ¿Þ´Ù¸®
		glColor3f(0.0, 1.0, 1.0);
		glPushMatrix();
			glRotatef(legAngleL, 1.0f, 0.0f, 0.0f);
			glScalef(1.0, 8.0, 1.0);
			glTranslatef(-0.5, -0.2, 1.0);
			glutSolidCube(0.5);

			glColor3f(0.0, 0.0, 0.0);
			glPushMatrix();
				glScalef(1.0, 0.125, 1.0);
				glTranslatef(0.0, -2.4, 0.0);
				glutSolidCube(0.5);
			glPopMatrix();
		glPopMatrix();

		// ¿À¸¥´Ù¸®
		glColor3f(0.0, 1.0, 1.0);
		glPushMatrix();
			glRotatef(legAngleR, 1.0f, 0.0f, 0.0f);
			glScalef(1.0, 8.0, 1.0);
			glTranslatef(0.5, -0.2, 0.0);
			glutSolidCube(0.5);

			glColor3f(0.0, 0.0, 0.0);
			glPushMatrix();
				glScalef(1.0, 0.125, 1.0);
				glTranslatef(0.0, -2.4, 0.0);
				glutSolidCube(0.5);
			glPopMatrix();
		glPopMatrix();

	glPopMatrix();

	glFlush();
}

void timeFunc(int value)
{
	time = time + 0.1;

	headAngle += 5;
	if (headAngle >= 360) headAngle -= 360;

	armAngleL = sin(time) * 40;
	armAngleL = -armAngleR;

	legAngleL = sin(time) * 30;
	legAngleR = -legAngleR;

	glutPostRedisplay();
}

int main(int argc, char** argv)
{
	glutInit(&argc, argv);
	glutInitWindowSize(700, 700);
	glutCreateWindow("OpenGL Example");

	glutInitDisplayMode(GLUT_RGBA | GLUT_DEPTH);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	glOrtho(-6.0, 6.0, -6.0, 6.0, -1.0, 1.0);
	glEnable(GL_DEPTH_TEST);
	glClearColor(1.0, 1.0, 1.0, 1.0);
	glutDisplayFunc(MyDisplay);
	glutMainLoop();
	return 0;
}