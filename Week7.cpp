#include <iostream>
#include <thread>
#include <mutex>

using namespace std;

mutex m1;
mutex m2;

int counter = 0;

void countUp(){
	m1.lock();
	for (int i=0; i < 20; i++){
		counter++;
		cout<< counter << endl;
	}
	m1.unlock();

}

void countDown(){
	m2.lock();
	for (int i=0; i < 20; i++){
			counter--;
			cout<< counter << endl;
		}
	m2.unlock();

}

int main()
{
thread t1(countUp);
thread t2(countDown);

t1.join();
t2.join();

return 0;
}
