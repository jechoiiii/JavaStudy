/* 오류 메세지가 뜨는 이유? 브라우저에서 실행을 안하기 때문에 발생 
-> BUT 이 파일을 import해서 브라우저에서 실행하기 때문에 오류 메세지 무시할 것*/



// 회원정보 member를 저장하는 배열 members
var members = []; 
    // object -> 문자열 변환 : JSON.stringify()
    // 문자열 -> object : JSON.parse()


// 생성자 함수 Member 
//  -> 목적 : 자바스크립트의 객체를 생성
function Member(id, pw, name){
    this.userid = id;
    this.userpw = pw;
    this.username = name;
}


// 프로토타입으로 Member 객체의 공통메서드 정의 
//  -> 목적 : 메모리 save & 공통코드 일괄수정
Member.prototype.makeHtml = function(index) {
    
    console.log(this.userid+' : '+this.userpw+' : '+this.username);
    
    var memberHtml = '';
    memberHtml += '<tr>';
    memberHtml += ' <td>' + index + '</td>';
    memberHtml += ' <td>' + this.userid + '</td>';
    memberHtml += ' <td>' + this.userpw + '</td>';
    memberHtml += ' <td>' + this.username + '</td>';
    memberHtml += ' <td><a href="javascript:editMember('+index+')">수정</a> <a href="javascript:delMember('+index+')">삭제</a></td>';
    memberHtml += '</tr>';
 
    
    return memberHtml;
} 


// window.onload : 페이지의 모든 요소들이 로드되어야만 처리하기 위한 함수
window.onload = function() {    
    
    // localStorage에 저장하는 key -> members
    // localStorage.getItem('members') 저장 값이 없으면 null 반환
    if(localStorage.getItem('members') == null){
        // 초기배열 저장 : 배열을 문자열로 변환해서 저장
        localStorage.setItem('members', JSON.stringify(members));
    } else {
        // 저장 데이터를 배열에 대입 : 문자열 -> 배열로 변환해서 저장
        members = JSON.parse(localStorage.getItem('members'));
        
        console.log(members);
        
        setList();
    }
    
}
/*function load() {
    alert('외부 스크립트 파일에서 로드');
}*/



// 회원 등록 ----------------------------------------------------------------
function regMember() {
    
    // 사용자가 입력한 데이터를 확인
    // -> 유효성 검사
    // -> 사용자 정보를 저장하는 객체를 생성
    
    // 아이디
    var userid = document.querySelector('#userid');
    // 비밀번호
    var pw = document.getElementById('pw');    
    // 비밀번호 확인
    var repw = document.getElementById('repw');  
    // 이름
    var username = document.querySelector('#username');
    
    
    var check = false; // 유효성 검사 문제 없음
    
    
    // 공백문자 & 비밀번호 일치 확인 : trim()으로 공백 제거 후 문자열 비교
    if(userid.value.trim().length < 1) {
        document.querySelector('#userid+div.msg').style.display = 'block'; // 블럭 처리로 줄바꿈
        check = true; // 유효성 검사 문제 발생
    }
    if(pw.value.trim().length < 1) {
        document.querySelector('#pw+div.msg').style.display = 'block';
        check = true;
    }
    if(repw.value.trim().length < 1 || pw.value!=repw.value) {
        document.querySelector('#repw+div.msg').style.display = 'block';
        check = true;
    }
    if(username.value.trim().length < 1) {
        document.querySelector('#username+div.msg').style.display = 'block';
        check = true;
    }
    
    
    
    // 이벤트 리스너 전달 : focus 들어가면 메세지 사라지도록
    // 대상객체.addEventListener(이벤트명, 실행할이벤트리스너)
   /* userid.onfocus = function() {
        document.querySelector('#userid+div.msg').style.display='none'; // focus하면 메세지 사라지도록
    }
    */
    userid.addEventListener('focus', function(){
        document.querySelector('#userid+div.msg').style.display = 'none';
        userid.value = '';
    });
    pw.addEventListener('focus', function(){
        document.querySelector('#pw+div.msg').style.display = 'none';
        pw.value = '';
    });
    repw.addEventListener('focus', function(){
        document.querySelector('#repw+div.msg').style.display = 'none';
        repw.value = '';
    });
    username.addEventListener('focus', function(){
        document.querySelector('#username+div.msg').style.display = 'none';
        username.value = '';
    });
    
    console.log(check);
    
    if(check){
        return false;
    }
    
    
    /*var member = {
        memberid: userid.value,
        pw: pw.value,
        membername: username.value
    };*/
    
    // 객체 생성 : id, pw, name 정보 지닌 member 객체
    var member = new Member(userid.value, pw.value, username.value); 
    
    //console.log('member', member);
    member.makeHtml();
    
    
    // 배열에 회원 정보를 저장 : members 배열에 memeber 요소 추가
    members.push(member);
    console.log('members', members);
    
  
    // 등록 완료 후 입력칸 초기화 : reset() 이용
    document.querySelector('#regform').reset();    
    
    
    // localStorage 저장
    // localStorage.setItem(Key, Value)    
    localStorage.setItem('members', JSON.stringify(members));
    alert('등록되었습니다');
    
    
    // 리스트 갱신
    setList();    
    
    
    // 이벤트가 전파되지 않도록 중단
    return false; 
}


// 회원 리스트 ---------------------------------------------------------------

// 리스트 테이블의 정렬 
function setList() {
    
    // table tbody 캐스팅
    var listrow = document.querySelector('#listrow');
    
    var tbody = '<tr>';
    tbody += '<th>순번(index)</th>';
    tbody += '<th>아이디</th>';
    tbody += '<th>비밀번호</th>';
    tbody += '<th>이름</th>';
    tbody += '<th>관리</th>';
    tbody += '</tr>';
    
    for(var i=0; i<members.length; i++){
        //tbody += members[i].makeHtml(i); => 사용 불가 
        
        tbody += '<tr>';
        tbody += ' <td>' + i + '</td>';
        tbody += ' <td>' + members[i].userid + '</td>';
        tbody += ' <td>' + members[i].userpw + '</td>';
        tbody += ' <td>' + members[i].username + '</td>';
        tbody += ' <td><a href="javascript:editMember('+i+')">수정</a> <a href="javascript:delMember('+i+')">삭제</a></td>';
        tbody += '</tr>';
    
    }
    
    listrow.innerHTML = tbody;
    
}


// 배열의 데이터 삭제 
function delMember(index){
    
    var delChk = confirm('삭제하시겠습니까?');
    
    if(delChk){
        
        // 삭제 -> 배열에서 요소 삭제
        members.splice(index, 1); // index 값 1개 삭제
        
        // localStorage 저장
        localStorage.setItem('members', JSON.stringify(members));
           
        alert('삭제되었습니다.');
        
        // 배열의 변경된 내용으로 리스트 출력
        setList();        
    }
    
}



// 회원정보 수정 -------------------------------------------------------------

// 데이터 수정 화면 Form
function editMember(index){
    console.log(members[index]);
    
    // 수정 화면 캐스팅
    var editDiv = document.querySelector('div.edit_div');
    editDiv.style.display = 'block';
    
    // form 안에 있는 input 캐스팅 (입력란에 id/name 넣기)
    // index  
    //      index 캐스팅 목적 -> 기존 데이터들과 match해서 변경하기 위해
    var idx = document.querySelector('#index');
    // id
    var eid = document.querySelector('#editid');
    // name
    var ename = document.querySelector('#editname');
    // pw
    var epw = document.querySelector('#editpw');
    // repw
    var erepw = document.querySelector('#editrepw');
    
    
    idx.value = index; 
    eid.value = members[index].userid;
    ename.value = members[index].username;
    epw.value = members[index].userpw;
    erepw.value = members[index].userpw;
    
}


// 데이터 수정 화면 닫기
function editMemberClose(){
    // 수정 화면 캐스팅   
    var editDiv = document.querySelector('div.edit_div');
    editDiv.style.display = 'none';
}


// 데이터 수정
function editMemberData(){
    
    // 캐스팅 (id 제외)
    // index
    var eidx = document.querySelector('#index').value;
    // pw
    var epw = document.querySelector('#editpw');
    // repw
    var erepw = document.querySelector('#editrepw');
    // name
    var ename = document.querySelector('#editname');
    
    
    // editpw > msg 캐스팅
    var pw_msg = document.querySelector('#editpw+div.msg');
    var repw_msg = document.querySelector('#editrepw+div.msg');
    var name_msg = document.querySelector('#editname+div.msg');
    
    
    
    var check = false; // 유효성 검사 문제 없음
    
    
    // 공백문자 & 비밀번호 일치 확인 메세지 
    if(epw.value.trim().length < 1) {
       pw_msg.style.display = 'block';
        check = true;
    }
    if(erepw.value.trim().length < 1 || epw.value != erepw.value) {
        repw_msg.style.display = 'block';
        check = true;
    }
    if(ename.value.trim().length < 1) {
        name_msg.style.display = 'block';
        check = true;
    }
    
    
    
    // 이벤트 리스너 전달 : focus 들어가면 메세지 사라지도록
    epw.addEventListener('focus', function(){
        pw_msg.style.display = 'none';
        epw.value = '';
    });
    erepw.addEventListener('focus', function(){
        repw_msg.style.display = 'none';
        erepw.value = '';
    });
    ename.addEventListener('focus', function(){
        name_msg.style.display = 'none';
        ename.value = '';
    });
    
    console.log(members);
    console.log(check);
    
    
    if(check){
        return false;
    }
    
    // members[index] => pw, name 수정
    members[eidx].username = ename.value.trim();
    members[eidx].userpw = epw.value;
    
    
    // localStorage 저장
    localStorage.setItem('members', JSON.stringify(members));
    alert('수정되었습니다.');
    
    
    // 회원 리스트 갱신
    setList();
    
    
     // 수정 완료 후 입력칸 초기화
    document.querySelector('#editform').reset();
    document.querySelector('div.edit_div').style.display = 'none';
    

    // 이벤트가 전파되지 않도록 중단
    return false;   
}












