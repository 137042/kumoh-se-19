#include<stdio.h>
using namespace std;

#include<GL/glut.h>
#include <gl/GL.h>
#include<gl/GLU.h>

#include "BunnyModel.h"


void MyDisplay()
{
	const int endOfLoop = 16301;
	glClear(GL_COLOR_BUFFER_BIT);
	glBegin(GL_LINES);
	for(int i = 0; i < endOfLoop; i++)
	{
		int vi;
		vi = face_indicies[i][0];
		glVertex3f(vertices[vi][0], vertices[vi][1], vertices[vi][2]);
		vi = face_indicies[i][1];
		glVertex3f(vertices[vi][0], vertices[vi][1], vertices[vi][2]);
		vi = face_indicies[i][2];
		glVertex3f(vertices[vi][0], vertices[vi][1], vertices[vi][2]);		
		
		//vi = face_indicies[i][1];
		//glVertex3f(vertices[vi][0], vertices[vi][1], vertices[vi][2]);
		//vi = face_indicies[i][2];
		//glVertex3f(vertices[vi][0], vertices[vi][1], vertices[vi][2]);
		//vi = face_indicies[i][0];
		//glVertex3f(vertices[vi][0], vertices[vi][1], vertices[vi][2]);
	}
	glEnd();
	glFlush();
}

int main(int argc, char* argv[])
{
	glutInit(&argc, argv);
	glutCreateWindow("OpenGL Example");

	glutDisplayFunc(MyDisplay);
	glutMainLoop();
}