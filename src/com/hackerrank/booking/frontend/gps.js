/**
 * Created by Aakash on 11-Aug-16.
 */
function processData(input) {
    //Enter your code here
    var obj = JSON.parse(input);
    var pathLength  = obj.p1.path.length;
    var dist = 0;
    updateLoc = function(ch1, start){
        if(ch1 === 'U')
            start[1] +=1;

        if(ch1 === 'D')
            start[1] -=1;

        if(ch1 === 'R')
            start[0] +=1;
        if(ch1 === 'L')
            start[0] -=1;
    };
    isEqual = function(start1, start2){
        if(start1[0] === start2[0] && start1[1] === start2[1]){
            return true;
        }
        return false;
    }
    for(var i=0;i<pathLength;i++){
        updateLoc(obj.p1.path.charAt(i), obj.p1.start);
        updateLoc(obj.p2.path.charAt(i), obj.p2.start);
        dist++;
        if(isEqual(obj.p1.start, obj.p2.start)){
            console.log(obj.p1.start[0]+","+obj.p1.start[1]+" "+dist);
            return;
        }
    }

}
