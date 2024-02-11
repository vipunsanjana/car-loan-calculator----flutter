
import 'package:flutter/material.dart';

void main() => runApp(MaterialApp(
  home: HomePage(),
  debugShowCheckedModeBanner: false,
));


class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
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
      body: body(),
    );
  }
  Widget body(){
    return Container(

    );
  }
}

