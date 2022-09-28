#include<stdio.h>
using namespace std;

#include<GL/glut.h>
#include <gl/GL.h>
#include<gl/GLU.h>

#include "BunnyModel.h"

// short face_indicies[16301][6] --> p1, p2, p3
// GLfloat vertices[8146][3] --> x, y, z
int zRotate = 0, dir = 0;

//GLuint g_objectID = -1;
//
//GLint GenerateCallList()
//{
//	GLint lid = glGenLists(1);
//}

void MyDisplay()
{
	glClear(GL_COLOR_BUFFER_BIT);
	glLoadIdentity();
	glRotatef(zRotate, 0.0, 1.0, 0.0);
	glBegin(GL_LINES);
	for (int i = 0; i < 16301; i++)
	{
		int vi;
		vi = face_indicies[i][0];
		glVertex3f(vertices[vi][0], vertices[vi][1], vertices[vi][2]);
		vi = face_indicies[i][1];
		glVertex3f(vertices[vi][0], vertices[vi][1], vertices[vi][2]);

		vi = face_indicies[i][1];
		glVertex3f(vertices[vi][0], vertices[vi][1], vertices[vi][2]);
		vi = face_indicies[i][2];
		glVertex3f(vertices[vi][0], vertices[vi][1], vertices[vi][2]);

		vi = face_indicies[i][2];
		glVertex3f(vertices[vi][0], vertices[vi][1], vertices[vi][2]);
		vi = face_indicies[i][0];
		glVertex3f(vertices[vi][0], vertices[vi][1], vertices[vi][2]);
	}
	glEnd();
	glFlush();
}

void MyKeyboard(unsigned char KeyPressed, int X, int Y)
{
	switch (KeyPressed) {
		case 'Q':
			exit(0); break;
		case 'q':
			exit(0); break;
		case 'Z':
			zRotate += 10; break;
		case 'z':
			zRotate -= 10; break;
		case '+':
			dir = 1; break;
		case '-':
			dir = 0; break;
	}
	glutPostRedisplay();
}

void MyTimer(int value)
{
	if (dir == 0)
		zRotate += 10;
	else
		zRotate -= 10;
	glutPostRedisplay();
	glutTimerFunc(100, MyTimer, 1);
}

int main(int argc, char* argv[])
{
	glutInit(&argc, argv);
	glutCreateWindow("OpenGL Example");

	glutDisplayFunc(MyDisplay);
	glutKeyboardFunc(MyKeyboard);
	glutTimerFunc(100, MyTimer, 1);
	glutMainLoop();
	return 0;
}