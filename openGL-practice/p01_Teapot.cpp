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
	glutInitWindowSize(300, 300); // 윈도우 크기
	glutInitWindowPosition(100, 100); // (100,100) 위치에 윈도우
	glutInitDisplayMode(GLUT_RGB | GLUT_DOUBLE);
	glutCreateWindow("OpenGL Example");
	glutSetWindowTitle("Updated OpenGL Example");

	int screenWidth, screenHeight;
	int windowWidth, windowHeight;
	int windowX, windowY;

	// Properties
	screenWidth = glutGet(GLUT_SCREEN_WIDTH); // 화면 너비
	screenHeight = glutGet(GLUT_SCREEN_HEIGHT); // 화면 크기
	windowWidth = glutGet(GLUT_WINDOW_WIDTH); // 윈도우 너비
	windowHeight = glutGet(GLUT_WINDOW_HEIGHT); // 윈도우 크기
	windowX = glutGet(GLUT_INIT_WINDOW_X); // 윈도우 X 좌표
	windowY = glutGet(GLUT_INIT_WINDOW_Y); // 윈도우 Y 좌표

	printf("Screen Info: %d %d\n", screenWidth, screenHeight);
	printf("Window Info: %d %d\n", windowWidth, windowHeight);
	printf("Window pos.: %d %d\n", windowX, windowY);

	glutDisplayFunc(MyDisplay); // 디스플레이 콜백 등록
	glutMainLoop(); // 이벤트 루프
}