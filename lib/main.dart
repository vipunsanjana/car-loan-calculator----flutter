
import 'package:flutter/material.dart';


void main() => runApp(const MaterialApp(
  home: HomePage(),
  debugShowCheckedModeBanner: false,
));


class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {

  final TextEditingController _controller1 = TextEditingController();
  final TextEditingController _controller2 = TextEditingController();
  final TextEditingController _controller3 = TextEditingController();

  String? selected;
  late double totalInterest;
  late double monthlyInterest;
  late double monthlyInstallment;


  void loanCalculate(){

    final amount = int.parse(_controller1.text) - int.parse(_controller2.text);
    final tinterest = amount * (double.parse(_controller3.text) / 100 * int.parse(selected!));
    final minterst = tinterest / (int.parse(selected!) * 12);
    final minstall = (amount + tinterest) / (int.parse(selected!) *12);

    setState(() {
      totalInterest = tinterest;
      monthlyInterest = minterst;
      monthlyInstallment = minstall;
    });

  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        leading: const Icon(
          Icons.notes,
          size: 30,
          color: Colors.black,
        ),
        toolbarHeight: 40,
        backgroundColor: Colors.yellow,
        elevation: 0,
        actions: const [
          Icon(
            Icons.info,
            size: 40,
            color: Colors.black,
          )
        ],
      ),
      body: SingleChildScrollView(
        child: body(),
      ),
    );
  }
  Widget body(){
    return Container(
      color: Colors.grey[300],
        child: Column(
          children: [
            Container(
              height: 170,
              decoration: const BoxDecoration(
                color: Colors.blue,
                borderRadius: BorderRadius.only(
                    bottomLeft: Radius.circular(40),
                    bottomRight: Radius.circular(40)
                )
              ),
              child:  const Padding(
                padding: EdgeInsets.only(top: 20.0),
                child: Align(
                  alignment: Alignment.center,
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.center,
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Text(
                        "Car Loan",
                        style: TextStyle(
                          fontFamily: 'RobotoMono',
                          fontSize: 35,
                        ),
                      ),
                      Text(
                        "Calculator",
                        style: TextStyle(
                          fontFamily: 'RobotoMono',
                          fontSize: 35,
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            ),
            const SizedBox(
              height: 10,
            ),
            Padding(
              padding: const EdgeInsets.fromLTRB(30,10,40,0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  inputForm(
                    title: "Car Price : ",
                    controller: _controller1,
                    hinttext: "e.g : 90000"
                  ),inputForm(
                    title: "Down Payment",
                    controller: _controller2,
                    hinttext: "e.g : 9000"
                  ),inputForm(
                    title: "Interest Rate : ",
                    controller: _controller3,
                    hinttext: "e.g : 3"
                  ),
                  const Text(
                    "Loan Period",
                    style: TextStyle(
                      fontFamily: 'RobotoMono',
                      fontSize: 20,
                    ),
                  ),
                  const SizedBox(
                    height: 5,
                  ),
                  Row(
                    children: [
                      loanPeriod("1"),loanPeriod("2"),loanPeriod("3"),loanPeriod("4"),loanPeriod("5"),
                    ],
                  ),
                  const SizedBox(
                    height: 5,
                  ),
                  Row(
                    children: [
                      loanPeriod("6"),loanPeriod("7"),loanPeriod("8"),loanPeriod("9"),
                    ],
                  ),
                  const SizedBox(
                    height: 30,
                  ),
                  GestureDetector(
                    onTap: (){
                      loanCalculate();
                      Future.delayed(Duration.zero);
                      showModalBottomSheet(
                        isDismissible: false,
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(30),
                          ),
                          context: context,
                          builder: (BuildContext context){
                            return SizedBox(
                              height: 400,
                              child:  Padding(
                                padding: const EdgeInsets.fromLTRB(20,30,0,0),
                                child: Column(
                                  crossAxisAlignment: CrossAxisAlignment.start,
                                  children: [
                                    const Text(
                                      "Result : ",
                                      style: TextStyle(
                                        fontFamily: 'RobotoMono',
                                        fontSize: 20,
                                      ),
                                    ),
                                    const SizedBox(
                                      height: 15,
                                    ),
                                    result(
                                      title: "Total Interest : ",
                                      amount: totalInterest,
                                    ),
                                    result(
                                      title: "Monthly Interest : ",
                                      amount: monthlyInterest,
                                    ),
                                    result(
                                      title: "Monthly Installment : ",
                                      amount: monthlyInstallment,
                                    ),
                                    const SizedBox(
                                      height: 20,
                                    ),
                                    Padding(
                                      padding: const EdgeInsets.only(right: 20),
                                      child: Container(
                                        height: 50,
                                        width: double.infinity,
                                        decoration: BoxDecoration(
                                            color: Colors.blue,
                                            borderRadius: BorderRadius.circular(25)
                                        ),
                                        child:  const Center(
                                          child: Text(
                                            "Re Calculate",
                                            style: TextStyle(
                                              fontFamily: 'RobotoMono',
                                              fontSize: 20,
                                            ),
                                          ),
                                        ),
                                      ),
                                    ),
                                    const SizedBox(
                                      height: 10,
                                    ),
                                  ],
                                ),
                              ),
                            );
                          },
                      );
                    },
                    child: Container(
                      height: 50,
                      width: double.infinity,
                      decoration: BoxDecoration(
                        color: Colors.blue,
                        borderRadius: BorderRadius.circular(25)
                      ),
                      child:  const Center(
                        child: Text(
                          "Calculate",
                          style: TextStyle(
                            fontFamily: 'RobotoMono',
                            fontSize: 20,
                          ),
                        ),
                      ),
                    ),
                  ),
                  const SizedBox(
                    height: 40,
                  ),
                ],
              ),
            ),
          ],
        ),
    );
  }
  Widget result({required String title, required double amount}){
    return ListTile(
      title: Text(
        title,
        style: const TextStyle(
          fontFamily: 'RobotoMono',
          fontSize: 20,
        ),
      ),
      trailing: Padding(
        padding: const EdgeInsets.only(right: 20), // Remove const here
        child: Text(
          "RM ${amount.toStringAsFixed(2)}",
          style: const TextStyle(
            fontFamily: 'RobotoMono',
            fontSize: 20,
          ),
        ),
      ),
    );
  }


  Widget loanPeriod(String title){
    return GestureDetector(
      onTap: () {
        setState(() {
          selected = title;
        });
      },
      child: Padding(
        padding: const EdgeInsets.fromLTRB(0,2,20,0),
        child: Container(
          height: 40,
          width: 40,
          decoration: BoxDecoration(
            border: title == selected ? Border.all(
              color: Colors.red,
              width: 3,
            ) : null,
            color: Colors.blue,
            borderRadius: BorderRadius.circular(10),
          ),
          child: Center(
            child: Text(
              title,
            ),
          ),
        ),
      ),
    );
  }

  Widget inputForm({required String title,required TextEditingController controller,required String hinttext}){
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(title,
          style: const TextStyle(
            fontFamily: "roboto",
            fontSize: 20,
          ),
        ),
        const SizedBox(
          height: 5,
        ),
        Container(
          height: 60,
          decoration: BoxDecoration(
            color: Colors.white,
            borderRadius: BorderRadius.circular(20),
          ),
          child:  TextField(
            controller: controller,
            decoration: InputDecoration(
              border: const OutlineInputBorder(borderSide: BorderSide.none),
              hintText: hinttext,
            ),
          ),
        ),
        const SizedBox(
          height: 10,
        )
      ],
    );
  }
}

