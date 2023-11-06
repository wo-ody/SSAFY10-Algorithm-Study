import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int K; // K번 회전
	static int gearPoles = 8;
	static Gear[] gear; // 톱니바퀴를 관리하기 위한 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		gear = new Gear[4]; // 톱니바퀴 개수만큼 생성

		// 톱니바퀴 각 상태 입력 받기
		for (int i = 0; i < 4; i++) {
			gear[i] = new Gear(br.readLine().toCharArray());
		}

		// K번만큼 선택한 톱니바퀴와 회전할 방향 입력받기
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());

			// 명령에 따라 회전
			revolve(number - 1, direction);
		}

		// 정답 출력
		System.out.println(getAnswer());

	}

	// command와 direction에 따라 전체가 회전하는 메서드
	static void revolve(int number, int direction) {

		boolean sameBetweenOneTwo = gear[0].getRightElement() == gear[1].getLeftElement();
		boolean sameBetweenTwoThree = gear[1].getRightElement() == gear[2].getLeftElement();
		boolean sameBetweenThreeFour = gear[2].getRightElement() == gear[3].getLeftElement();

		// 첫번째 톱니바퀴가 회전한 경우
		if (number == 0) {
			if (direction == 1) {
				gear[number].turnRight();
				if (!sameBetweenOneTwo) {
					gear[1].turnLeft();
					if (!sameBetweenTwoThree) {
						gear[2].turnRight();
						if (!sameBetweenThreeFour) {
							gear[3].turnLeft();
						}
					}
				}
			} else {
				gear[number].turnLeft();
				if (!sameBetweenOneTwo) {
					gear[1].turnRight();
					if (!sameBetweenTwoThree) {
						gear[2].turnLeft();
						if (!sameBetweenThreeFour) {
							gear[3].turnRight();
						}
					}
				}
			}
			// 두번째 톱니바퀴가 회전한 경우
		} else if (number == 1) {

			if (direction == 1) {
				gear[number].turnRight();
				if (!sameBetweenOneTwo) {
					gear[0].turnLeft();
				}
				if (!sameBetweenTwoThree) {
					gear[2].turnLeft();
					if (!sameBetweenThreeFour) {
						gear[3].turnRight();
					}
				}

			} else {
				gear[number].turnLeft();
				if (!sameBetweenOneTwo) {
					gear[0].turnRight();
				}
				if (!sameBetweenTwoThree) {
					gear[2].turnRight();
					if (!sameBetweenThreeFour) {
						gear[3].turnLeft();
					}
				}
			}

			// 세번째 톱니바퀴가 회전한 경우
		} else if (number == 2) {
			if (direction == 1) {
				gear[number].turnRight();
				if (!sameBetweenThreeFour) {
					gear[3].turnLeft();
				}
				if (!sameBetweenTwoThree) {
					gear[1].turnLeft();
					if (!sameBetweenOneTwo) {
						gear[0].turnRight();
					}
				}

			} else {
				gear[number].turnLeft();
				if (!sameBetweenThreeFour) {
					gear[3].turnRight();
				}
				if (!sameBetweenTwoThree) {
					gear[1].turnRight();
					if (!sameBetweenOneTwo) {
						gear[0].turnLeft();
					}
				}
			}

			// 네번째 톱니바퀴가 회전한 경우
		} else {
			if (direction == 1) {
				gear[number].turnRight();
				if (!sameBetweenThreeFour) {
					gear[2].turnLeft();
					if (!sameBetweenTwoThree) {
						gear[1].turnRight();
						if (!sameBetweenOneTwo) {
							gear[0].turnLeft();
						}
					}
				}
			} else {
				gear[number].turnLeft();
				if (!sameBetweenThreeFour) {
					gear[2].turnRight();
					if (!sameBetweenTwoThree) {
						gear[1].turnLeft();
						if (!sameBetweenOneTwo) {
							gear[0].turnRight();
						}
					}
				}
			}
		}
	}

	// 네 톱니바퀴의 점수의 합을 반환하는 메서드
	static int getAnswer() {
		int sum = 0;
		if (gear[0].getTopElement() == '1')
			sum += 1;
		if (gear[1].getTopElement() == '1')
			sum += 2;
		if (gear[2].getTopElement() == '1')
			sum += 4;
		if (gear[3].getTopElement() == '1')
			sum += 8;

		return sum;

	}

	// 톱니바퀴 값과 기능을 정의하는 클래스
	static class Gear {
		char[] poles = new char[gearPoles];

		Gear(char[] c) {
			poles = c;
		}

		// 왼쪽으로 회전
		void turnLeft() {
			char tmp = poles[0];
			for (int i = 0; i < gearPoles - 1; i++) {
				poles[i] = poles[i + 1];
			}
			poles[gearPoles - 1] = tmp;
		}

		// 오른쪽으로 회전
		void turnRight() {
			char tmp = poles[gearPoles - 1];
			for (int i = gearPoles - 1; i > 0; i--) {
				poles[i] = poles[i - 1];
			}
			poles[0] = tmp;
		}

		// 왼쪽 극 얻기
		char getLeftElement() {
			return poles[6];
		}

		// 오른쪽 극 얻기
		char getRightElement() {
			return poles[2];
		}

		// 위쪽 극 얻기 -> 0번 위치가 12시 방향
		char getTopElement() {
			return poles[0];
		}
	}
}
