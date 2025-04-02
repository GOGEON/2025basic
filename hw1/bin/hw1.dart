import 'package:hw1/hw1.dart' as hw1;

import 'dart:io';

void main() {
  stdout.write("양의 정수를 입력하세요: ");
  String input = stdin.readLineSync()!;

  if (int.parse(input) <= 0) {
    print(input);
    return;
  }

  int number = int.parse(input);
  int sum = 0;

  while (number > 0) {
    sum += number % 10;
    number ~/= 10;
  }

  print("자리수 합: $sum");
}
