/**
 * Created by Aakash on 11-Aug-16.
 */
function processData(input) {
    //Enter your code here
    input = input.split('\n');
    var n = input[0];
    var list = [];
    for(var i=1;i<=n;i++){
        var arr = input[i].split(":");
        var id = arr[0];
        var msg = arr[1].substring(arr[1].lastIndexOf('(')+1);// remove '('
        var count = 0;
        var timeoutArray = msg.split(')');
        for(var j=0;j<timeoutArray.length-1;j++){
            var timeout = parseInt(timeoutArray[j].trim());
            if(timeout && timeout > 0) {
                count += timeout;
            }
        }
        var message = {};
        message['id'] = id;
        message['time'] = count;
        list.push(message);
    }
    list.sort(function(msg1, msg2){
        return msg1.time < msg2.time ? -1 : (msg1.time > msg2.time ? 1 : 0);
    });
    for(var i=0;i<list.length;i++){
        console.log(list[i].id.trimRight()+".");
    }
} 