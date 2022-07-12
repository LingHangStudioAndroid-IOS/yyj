import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    TextEditingController _selectionController =  TextEditingController();
    _selectionController.text="hello world!";
    _selectionController.selection=TextSelection(
      baseOffset: 2,
      extentOffset: _selectionController.text.length
    );
    FocusNode focusNode1 = FocusNode();
    FocusNode focusNode2 = FocusNode();
    FocusScopeNode focusScopeNode;


    
    return Scaffold(
      appBar: AppBar(
        
        title: Text(widget.title),
      ),
      body: Center(
        
        child: Column(
        
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              '$_counter',
              style: Theme.of(context).textTheme.headline4,
            ),
            TextField(
              controller: _selectionController
            ),
            TextField(
              autofocus: true, 
              focusNode: focusNode1,
              decoration: InputDecoration(
                labelText: "input1"
              ),
            ),
            TextField(
              focusNode: focusNode2,
              decoration: InputDecoration(
                labelText: "input2"
              ),
            ),
            Builder(builder: (ctx) {
              return Column(
                children: <Widget>[
                  ElevatedButton(
                    child: Text("移动焦点"),
                    onPressed: () {
                      focusScopeNode = FocusScope.of(context);
                      
                      focusScopeNode.requestFocus(focusNode2);
                    },
                  ),
                  ElevatedButton(
                    child: Text("隐藏键盘"),
                    onPressed: () {
                      focusNode1.unfocus();
                      focusNode2.unfocus();
                    },
                  ),
                ],
              );
            },
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: const Icon(Icons.add),
      ), 
    );
  }
}

// class FocusTestRoute extends StatefulWidget {
//   @override
//   _FocusTestRouteState createState() =>  _FocusTestRouteState();
// }

// class _FocusTestRouteState extends State<FocusTestRoute> {
//   FocusNode focusNode1 = FocusNode();
//   FocusNode focusNode2 = FocusNode();
//   FocusScopeNode? focusScopeNode;

//   @override
//   Widget build(BuildContext context) {
//     return Padding(
//       padding: EdgeInsets.all(16.0),
//       child: Column(
//         children: <Widget>[
//           TextField(
//             autofocus: true, 
//             focusNode: focusNode1,//关联focusNode1
//             decoration: InputDecoration(
//                 labelText: "input1"
//             ),
//           ),
//           TextField(
//             focusNode: focusNode2,//关联focusNode2
//             decoration: InputDecoration(
//                 labelText: "input2"
//             ),
//           ),
//           Builder(builder: (ctx) {
//             return Column(
//               children: <Widget>[
//                 ElevatedButton(
//                   child: Text("移动焦点"),
//                   onPressed: () {
//                     //将焦点从第一个TextField移到第二个TextField
//                     // 这是一种写法 FocusScope.of(context).requestFocus(focusNode2);
//                     // 这是第二种写法
//                     if(null == focusScopeNode){
//                       focusScopeNode = FocusScope.of(context);
//                     }
//                     focusScopeNode.requestFocus(focusNode2);
//                   },
//                 ),
//                 ElevatedButton(
//                   child: Text("隐藏键盘"),
//                   onPressed: () {
//                     // 当所有编辑框都失去焦点时键盘就会收起  
//                     focusNode1.unfocus();
//                     focusNode2.unfocus();
//                   },
//                 ),
//               ],
//             );
//           },
//           ),
//         ],
//       ),
//     );
//   }

// }





