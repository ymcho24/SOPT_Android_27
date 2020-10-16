# SOPT_Android_27
### 📌 1주차
(update 2020/10/16)
<br><br>

#### **📱 구현 화면**
<br>

 ![ezgif-4-31575e2815d9](https://user-images.githubusercontent.com/52772787/96249279-ef34a980-0fe7-11eb-8466-606d8b4a5591.gif)

 <br>
 
 #### **💻 필수 과제**
 <br>
 
 > ##### 회원가입 완료 클릭 이벤트
 
 ```kotlin
 if (edittext_name.text.toString().isNotEmpty() && edittext_id.text.toString().isNotEmpty()
                && edittext_pwd.text.toString().isNotEmpty()) {
                Toast.makeText(this, "회원가입이 완료되었습니다", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "빈 칸을 채워주세요", Toast.LENGTH_SHORT).show()
            }
 ```
 
 - 모든 EditText의 text가 비어있지 않을 경우 회원가입 완료 ToastMessage가 뜨고, 하나라도 비어있는 칸이 있다면 빈 칸이 있다는 ToastMessage가 뜨도록 조건문을 사용해서 구현했습니다.
 
 <br>
 
 > ##### 비밀번호 암호화 및 hint 속성 사용
 
 ```kotlin
 android:inputType="textPassword"
 android:hint="비밀번호를 입력해주세요"
 ```
 
 <br>
 
  #### **💻 성장 과제 1**
  <br>
  
 > ##### 화면 이동 및 자동 입력
 
- startActivityForResult를 사용하여, LoginActivity에서 호출한 SignUpActivity가 종료되면서 다시 LoginActivity로 아이디 및 비밀번호를 보내도록 했습니다.
- LoginActivity에서 startActivityForResult(Intent, requestCode)로 SignUpActivity를 호출하고 onActivityResult()에서 결과를 받습니다.
 
 <br>
 
 ##### LoginActivity
 
 ```kotlin
 textview_sign_up.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivityForResult(intent, 1);
        }
 ```
 
 - textview_sign_up 버튼 클릭 시, intent와 requestCode인 1을 넣어 SignUpActivity로 이동하도록 했습니다.
 
 <br>
 
 ```kotlin
 override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 1) {
                editText_id.setText(data!!.getStringExtra("id"))
                editText_pwd.setText(data!!.getStringExtra("pwd"))
            }
        }
    }
 ```
 
 -  resultCode가 RESULT_OK일 때 requestCode의 값에 맞게 동작합니다.
 
 <br>
 
 ##### SignUpActivity
 
 ```kotlin
 val id = edittext_id.text.toString()
 val pwd = edittext_pwd.text.toString()

val intent = Intent(this, LoginActivity::class.java)
intent.putExtra("id", id)
intent.putExtra("pwd", pwd)
setResult(Activity.RESULT_OK, intent)

finish()
 ```
 
 - 사용자로부터 입력받은 아이디와 비밀번호 값을 intent에 넣어주고, setResult를 호출하여 RESULT_OK와 해당 intent를 LoginActivity로 보냈습니다.
 - finish 호출로 SignUpActivity사 종료되면서 다시 LoginActivity로 돌아오고, 이 때 LoginActivity의 onActivityResult가 동작합니다.


<br><br>

