#include<stdio.h>
using namespace std;

#include<GL/glut.h>
#include <gl/GL.h>
#include<gl/GLU.h>


void MyDisplay()
{
	glClear(GL_COLOR_BUFFER_BIT);
	//glBegin(GL_POLYGON);
	//glColor3f(1.0, 0, 0);	glVertex3f(-0.5, -0.5, 0.0);
	//glColor3f(0, 1.0, 0);	glVertex3f(0.5, -0.5, 0.0);
	//glColor3f(0, 0, 1.0);	glVertex3f(0.5, 0.5, 0.0);
	//glColor3f(0, 1.0, 1.0);	 glVertex3f(-0.5, 0.5, 0.0);
	glColor3f(1.0, 0, 0);
	glutWireTeapot(0.5);
	
	glutSwapBuffers();
}

int main(int argc, char* argv[])
{
	glutInit(&argc, argv);
	glutInitWindowSize(300, 300); // ������ ũ��
	glutInitWindowPosition(100, 100); // (100,100) ��ġ�� ������
	glutInitDisplayMode(GLUT_RGB | GLUT_DOUBLE);
	glutCreateWindow("OpenGL Example");
	glutSetWindowTitle("Updated OpenGL Example");

	int screenWidth, screenHeight;
	int windowWidth, windowHeight;
	int windowX, windowY;

	// Properties
	screenWidth = glutGet(GLUT_SCREEN_WIDTH); // ȭ�� �ʺ�
	screenHeight = glutGet(GLUT_SCREEN_HEIGHT); // ȭ�� ũ��
	windowWidth = glutGet(GLUT_WINDOW_WIDTH); // ������ �ʺ�
	windowHeight = glutGet(GLUT_WINDOW_HEIGHT); // ������ ũ��
	windowX = glutGet(GLUT_INIT_WINDOW_X); // ������ X ��ǥ
	windowY = glutGet(GLUT_INIT_WINDOW_Y); // ������ Y ��ǥ

	printf("Screen Info: %d %d\n", screenWidth, screenHeight);
	printf("Window Info: %d %d\n", windowWidth, windowHeight);
	printf("Window pos.: %d %d\n", windowX, windowY);

	glutDisplayFunc(MyDisplay); // ���÷��� �ݹ� ���
	glutMainLoop(); // �̺�Ʈ ����
}