function load() {
    alert('외부 스크립트 파일에서 로드');
}


var phoneBook = [];

// 생성자 함수 
function PhoneInfo(name, pNum, email, memo){
    this.name = name;
    this.phoneNum = pNum;
    this.email = email;
    this.memo = memo;
}


// 프로토타입 : PhoneInfo 객체의 공통메서드
PhoneInfo.prototype.makeHtml = function(index) {
    
    var phoneInfoHtml = '';
    
    phoneInfoHtml += '<tr>';
    phoneInfoHtml += '  <td>'+ index +'</td>';
    phoneInfoHtml += '  <td>'+ this.name +'</td>';
    phoneInfoHtml += '  <td>'+ this.phoneNum +'</td>';
    phoneInfoHtml += '  <td>'+ this.email +'</td>';
    phoneInfoHtml += '  <td>'+ this.memo +'</td>';
    phoneInfoHtml += '  <td><a href="javascript:editPhoneInfo('+index+')">수정</a> <a href="javascript:delPhoneInfo('+index+')">삭제<a></td>';
    phoneInfoHtml += '</tr>';
    
    return phoneInfoHtml;
}

window.onload = function() {
    
    if(localStorage.getItem('phoneBook') == null){  
        // 초기배열 문자열로 변환해서 저장
        localStorage.setItem('phoneBook', JSON.stringify(phoneBook)); 
    } else {
        // 저장된 데이터를 배열로 변환해서 저장
        phoneBook = JSON.parse(localStorage.getItem('phoneBook'));
        
        console.log(phoneBook);
        
        sortList();
    };
}



// 전화번호 추가 -----------------------------------

function addPhoneInfo() {
    
    // 사용자가 입력한 데이터 확인 > 유효성 검사 > 정보 저장하는 객체 생성
    
    var name = document.querySelector('#name');
    var phoneNum = document.querySelector('#phoneNum');
    var email = document.getElementById('email');
    var memo = document.getElementById('memo');
    
    var check = false; // 유효성 검사 문제 없음
    
    
    // 유효성 검사 : 공백문자 확인
    if(name.value.trim().length < 1){  
        document.querySelector('#name+div.msg').style.display='block';
        check = true;
    }
    if(phoneNum.value.trim().length < 1){  
        document.querySelector('#phoneNum+div.msg').style.display='block';
        check = true;
    }
    
    
    // 이벤트 리스너
     
    
    // 객체 생성
    var phoneInfo = new PhoneInfo(name.value, phoneNum.value, email.value, memo.value);
    
    phoneInfo.phoneInfoHtml();
    
    // 배열에 정보 저장
    phoneBook.push(phoneInfo);
    console.log('phoneBook', phoneBook);
    
    // 추가 완료 후 입력칸 초기화
    document.querySelector('#regForm').reset();
    
    // localStorage 저장
    localStorage.setItem('phoneBook', JSON.stringify(phoneBook));
    alert('등록되었습니다.');
    
    // 전화번호부 갱신
    sortList();
    
    // 이벤트 중단
    
}




// 전화번호부 리스트 --------------------------------

// 리스트 테이블 정렬
function sortList() {
    
    // table tbody 캐스팅
    var listTable = document.querySelector('#listTable');
    
    var tbody = '<tr>';
    tbody +=    '<th>No.</th>';
    tbody +=    '<th>이름</th>';
    tbody +=    '<th>전화번호</th>';
    tbody +=    '<th>이메일</th>';
    tbody +=    '<th>메모</th>';
    tbody +=    '<th>관리</th>';
    tbody += '</tr>'
    
    for(var i=0; i<phoneBook.length; i++){
        
        tbody = '<tr>';
        tbody +=    '<td>'+ i +'</td>';
        tbody +=    '<td>'+ phoneBook[i].name +'</td>';
        tbody +=    '<td>'+ phoneBook[i].phoneNum +'</td>';
        tbody +=    '<td>'+ phoneBook[i].email +'</td>';
        tbody +=    '<td>'+ phoneBook[i].memo +'</td>';
        tbody += '  <td><a href="javascript:editPhoneInfo('+index+')">수정</a> <a href="javascript:delPhoneInfo('+index+')">삭제<a></td>' 
        tbody += '</tr>';
    }
 
    listTable.innerHTML = tbody;
}


// 정보 삭제
function delPhoneInfo(index){
    
    var delChk = confirm('삭제하시겠습니까?');
    
    if(delChk){
        
        // 배열에서 요소 삭제
        phoneBook.splice(index, 1);
        
        // localStorage 저장
        localStorage.setItem('phoneBook', JSON.stringify(phoneBook));
        
        alert('삭제하였습니다.');
        
        // 전화번호부 갱신
        sortList();
    }
}




// 전화번호부 수정 ---------------------------------

// 데이터 수정 화면
function editScreen(index){
    
    // 캐스팅
    var editData = document.querySelector('div.editData');
    editData.style.display = 'block';
    
    // new input 캐스팅 + 입력란에 정보 넣기
    var idx = document.querySelector('#index');
    var eName = document.querySelector('#editName');
    var ePhoneNum = document.querySelector('#editPhoneNum');
    var eEmail = document.querySelector('#editEmail');
    var eMemo = document.querySelector('#editMemo');
    
    idx.value = index;
    ename.value = phoneBook[index].name;
    ePhoneNum.value = phoneBook[index].phoneNum;
    eEmail.value = phoneBook[index].email;
    eMemo.value = phoneBook[index].memo;

}


// 데이터 수정 화면 닫기
function editPhoneInfoClose(){
    
    // 수정 화면 캐스팅
    var editData = document.querySelector('div.editData');
    editData.style.display = "none";
    
}


// 데이터 수정
function editPhoneInfo() {
    
    // 캐스팅
    var idx = document.querySelector('#index').value;
    var eName = document.querySelector('#editName').value;
    var ePhoneNum = document.querySelector('#editPhoneNum').value;
    var eEmail = document.querySelector('#editEmail').value;
    var eMemo = document.querySelector('#editMemo').value;
    
    // msg 캐스팅
    var phoneNum_msg = document.querySelector('#editPhoneNum+div.msg');
    
    
    var check = false;
    
    
    // 유효성 검사 : 공백문자 확인 (전화번호)
    if(ePhoneNum.value.trim().length < 1){  
        phoneNum_msg.style.display = 'block';
        check = true;
    }
    
    
    // 이벤트 리스너
    
    
    // phoneBook[index] => phoneNum, email, memo 수정
    phoneBook[idx].phoneNum = ePhoneNum.value.trim();
    phoneBook[idx].email = eEmail.value.trim();
    phoneBook[idx].memo = eMemo.value;
    
    
    // localStorage 저장
    localStorage.setItem('phoneBook', JSON.stringify(phoneBook));
        
    alert('삭제하였습니다.');
    
    // 전화번호부 갱신
    sortList();
    
    // 수정완료 후 입력칸 초기화
    document.querySelector('#editForm').reset();
    
    document.querySelector('div.editData').style.display = 'none';
    
    // 이벤트 중단
}




































