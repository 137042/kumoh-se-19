#include<stdio.h>
using namespace std;

#include<GL/glut.h>
#include <gl/GL.h>
#include<gl/GLU.h>


GLint TopLeftX, TopLeftY, BottomRightX, BottomRightY;
int zRotate = 0; // 회전 값을 보관

void MyDisplay()
{
	//glClear(GL_COLOR_BUFFER_BIT);

	//glPointSize(4);
	//glBegin(GL_POINTS);
	//glColor3f(1.0, 0.0, 0.0);	glVertex3f(0.0, 0.0, 0.0);
	//glColor3f(0.0, 1.0, 0.0);	glVertex3f(0.5, 0.0, 0.0);
	//glColor3f(0.0, 0.0, 1.0);	glVertex3f(-0.5, -0.5, 0.0);

	//glLineWidth(4);
	//glBegin(GL_LINES);
	//glColor3f(0.0, 1.0, 0.0);
	//glVertex3f(-0.5, 0.2, 0.0); glVertex3f(0.5, 0.2, 0.0);
	//glColor3f(1.0, 0.0, 0.0);
	//glVertex3f(-0.5, -0.2, 0.0); glVertex3f(0.5, -0.2, 0.0);
	
	////삼각형 꼭짓점들을 선언할 때 선언 순서 중요함(면이 바라보는 방향 등에 영향)
	//glBegin(GL_TRIANGLES);
	//glColor3f(1.0, 1.0, 0.0);
	//glVertex3f(-0.4, 0.0, 0.0);	glVertex3f(-0.7, 0.0, 0.0);	glVertex3f(-0.9, 0.4, 0.0);
	//glColor3f(0.0, 0.0, 1.0);
	//glVertex3f(0.0, 0.0, 0.0);	glVertex3f(0.4, 0.0, 0.0);	glVertex3f(0.2, 0.3, 0.0);

	//glColor3f(1.0, 1.0, 1.0);
	//glutSolidSphere(0.5, 36, 12);

	//glRotatef(zRotate, 0.0, 0.0, 1.0); // z축을 기준으로 회전
	//glutWireTeapot(0.5);

	//glMatrixMode(GL_MODELVIEW);
	//glLoadIdentity();
	//glColor3f(1.0, 0.0, 0.0);
	//glBegin(GL_POLYGON);
	//glVertex3f(TopLeftX / 300.0, (300 - TopLeftY) / 300.0, 0.0);
	//glVertex3f(TopLeftX / 300.0, (300 - BottomRightY) / 300.0, 0.0);
	//glVertex3f(BottomRightX / 300.0, (300 - BottomRightY) / 300.0, 0.0);
	//glVertex3f(BottomRightX / 300.0, (300 - TopLeftY) / 300.0, 0.0);

	glColor3f(1.0, 0.0, 0.0);
	glBegin(GL_LINES);
	glVertex3f(TopLeftX / 300.0, (300 - TopLeftY) / 300.0, 0.0);
	glVertex3f(BottomRightX / 300.0, (300 - BottomRightY) / 300.0, 0.0);

	glEnd();
	glFlush();
}

void MyKeyboard(unsigned char KeyPressed, int X, int Y)
{
	switch (KeyPressed)
	{
		case 'z':
			zRotate -= 10;
			break;
		case 'Z':
			zRotate += 10;
			break;
		case 'q':	case 'Q':
			exit(0);
			break;
	}
	glutPostRedisplay();
}

void MyMouseClick(GLint Button, GLint State, GLint X, GLint Y)
{
	if (Button == GLUT_LEFT_BUTTON && State == GLUT_DOWN)
	{
		TopLeftX = X;
		TopLeftY = Y;
	}
}

void MyMouseMove(GLint X, GLint Y)
{
	BottomRightX = X;
	BottomRightY = Y;

	//glutPostRedisplay();
}

int main(int argc, char* argv[])
{
	glutInit(&argc, argv);
	glutCreateWindow("OpenGL Example");
	
	glMatrixMode(GL_PROJECTION);
	glOrtho(0.0, 1.0, 0.0, 1.0, -1.0, 1.0);

	glutDisplayFunc(MyDisplay);
	glutKeyboardFunc(MyKeyboard);
	glutMouseFunc(MyMouseClick);
	glutMotionFunc(MyMouseMove);
	glutMainLoop();
}