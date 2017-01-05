/**
 * Created by Aakash on 8/11/2016.
 */
function processData(input) {
    var obj = JSON.parse(input);
    var prevTemp = obj.initialTemperature;
    var endTime = new Date(obj.endTime).getTime();
    var prevTime = new Date(obj.inputs[0].time).getTime();
    if(prevTime >= endTime){
        console.log(prevTemp);
        return;
    }

    function getTemp(max, current, speed, diff) {
        var increase = max > current ? 1 : 0;
        var temp =  current + (diff / 60)* speed *(increase ? 1 : -1);
        if((increase && temp > max ) || (!increase && temp < max)) {
            return max;
        }
        return temp;
    }
    var i;
    for(i=1;i<obj.inputs.length;i++) {
        prevTime = new Date(obj.inputs[i - 1].time).getTime();

        var maxTemp = obj.inputs[i - 1].temperature;
        var time = new Date(obj.inputs[i].time).getTime();
        if (endTime < time) {
            var temp = getTemp(maxTemp, prevTemp, obj.speed, (endTime - prevTime)/60000);
            console.log(temp);
            return;
        }
        prevTemp = getTemp(maxTemp, prevTemp, obj.speed, (time - prevTime)/60000);
    }
    prevTime = new Date(obj.inputs[i - 1].time).getTime();
    var maxTemp = obj.inputs[i - 1].temperature;
    var temp = getTemp(maxTemp, prevTemp, obj.speed, (endTime - prevTime)/60000);
    console.log(temp);
} 