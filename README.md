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

* * *

### 📌 2주차
(update 2020/10/30)
<br><br>

#### **📱 구현 화면**
<br>

![ezgif com-gif-maker](https://user-images.githubusercontent.com/52772787/97652779-8f87d500-1aa2-11eb-830a-15ff52aff32e.gif)
![ezgif com-gif-maker (1)](https://user-images.githubusercontent.com/52772787/97652803-a5959580-1aa2-11eb-9477-a12008d4cc79.gif)


<br>

#### **💻 필수 과제**
 <br>
 
 > ##### 리사이클러뷰 아이템 클릭 이벤트
 
 ##### ProfileAdapter
 
 ```kotlin
holder.itemView.setOnClickListener {

            val title = data[position].title
            val subTitle = data[position].subTitle

            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("title", title)
            intent.putExtra("subTitle", subTitle)

            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
 ```
 
 - itemView 객체를 이용해서 recyclerView의 item에 접근할 수 있습니다.
 - holder의 itemView에 클릭 리스너를 추가하고, 각 item의 정보를 상세보기 화면으로 보내기 위해 intent에 담았습니다.
 - startActivity를 통해 DetailActivity로 해당 intent를 보냈습니다.
 
 <br>
 
 ##### DetailActivity
 
 ```kotlin
        val title = intent.getStringExtra("title")
        val subTitle = intent.getStringExtra("subTitle")

        textView_title.text = title
        textView_subTitle.text = subTitle
 ```
 
 - title과 subTitle 변수에 intent로 받아온 값을 할당했습니다.
 - 상세보기 화면의 textView에 title과 subTitle 값을 설정했습니다.
 
 <br>
 
 #### **💻 성장 과제 1**
 
 <br>
 
 > ##### GridLayout 만들기
 
 ##### GridFragment
 
 ```kotlin
       main_recycler_grid.adapter = gridAdapter
       main_recycler_grid.layoutManager = GridLayoutManager(context!!, 3)
 ```
 
 - GridLayoutManager의 spanCount를 3으로 지정해줬습니다. spanCount = 3일 때, 3열의 layout이 생성됩니다.
 
 <br><br>
 
 * * *

### 📌 3주차
(update 2020/11/6)
<br><br>

#### **📱 구현 화면**
<br>
 
![ezgif com-gif-maker (2)](https://user-images.githubusercontent.com/52772787/98332132-6981a800-2041-11eb-942e-6147bfe5d7af.gif)

<br>

#### **💻 필수 과제**
 <br>
 
 > ##### ViewPager 
 
 ##### SampleViewPagerAdapter
 
 ```kotlin
class SampleViewPagerAdapter(fm : FragmentManager)
    : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    var fragments = listOf<Fragment>()

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size
}
 ```
 
 - FragmentStatePagerAdapter를 상속함으로써 SampleViewPagerAdapter가 ViewPagerAdapter의 역할을 하도록 해줍니다. 
 - fragments라는 이름의 Fragment를 담은 리스트를 만들어 줍니다.
 - getItem() : 리스트에 있는 프래그먼트의 인스턴스를 새 페이지로 제공하는 함수
 - getCount() : Adapter에서 만들 페이지 수를 반환하는 함수
 
 <br>
 
  ##### MainActivity
 
 ```kotlin
private lateinit var viewPagerAdapter : SampleViewPagerAdapter
viewPagerAdapter =
            SampleViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.fragments = listOf(
            ProfileFragment(),
            LinearFragment(),
            GridFragment()
        )

        viewPager_main.adapter = viewPagerAdapter
 ```
 
 - Adapter의 fragments 변수에 Fragment를 생성해서 넣어줍니다.
 - viewPager의 id에 해당 Adapter를 장착해줍니다.
 
 <br><br>
 
  > ##### BottomNavigation
 
 ##### MainActivity
 
 ```kotlin
//하단 탭을 눌렀을 때 뷰페이저 화면 변경
        bottomNavi_sample.setOnNavigationItemSelectedListener {
            var index by Delegates.notNull<Int>()
            when(it.itemId) {
                R.id.menu_profile -> index = 0
                R.id.menu_obeject -> index = 1
                R.id.menu_pets -> index = 2
            }
            viewPager_main.currentItem = index
            true
        }
 ```
 
 - 각 탭을 클릭했을 때 호출될 이벤트 처리 Listener를 설정해줍니다.
 - menu item의 id 값을 통해 viewPager의 currentItem을 조작할 수 있습니다.
 - 이 과정까지 수행하면 하단 탭을 눌렀을 때 화면은 잘 변경되지만, 스와이프 하고 난 후에 하단탭의 변경은 일어나지 않습니다.
 
 <br><br>
 
 > ###### BottomNavigation : viewPager의 페이지 변경에 관한 리스너 장착
 
  ##### MainActivity
 
 ```kotlin
//뷰페이저를 슬라이드 했을 때 그에 대응하는 하단 탭 변경
        viewPager_main.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                bottomNavi_sample.menu.getItem(position).isChecked = true
            }

        })
 ```
 
 - viewPager의 화면 전환을 감지하는 리스너를 선언합니다.
 - Viewpager의 페이지 중 하나가 선택된 경우 그에 대응하는 하단 탭의 상태가 변경되도록 onPageSelected()를 오버라이드 해줍니다.
 
 <br><br>
 
 > ##### TabLayout
 
 ##### ProfileFragment
 
 ```kotlin
viewPagerAdapter = SampleViewPagerAdapter(childFragmentManager)
        viewPagerAdapter.fragments = listOf(
            FirstFragment(),
            SecondFragment()
        )

        viewpager_profile.adapter = viewPagerAdapter
 ```
 
 - TabLayout에 들어갈 ViewPager를 세팅해줍니다.
 - fragment 안에서 supportFragmentManager를 사용해야 할 때는, childFragmentManager를 통해 프래그먼트 매니저를 호출해야 합니다.
 
 <br>
 
  ```kotlin
//TapLayout과 연동
        tab_sample.setupWithViewPager(viewpager_profile)

        tab_sample.apply {
            getTabAt(0)?.text = "INFO"
            getTabAt(1)?.text = "OTHER"
        }
 ```
 
 - TabLayout에 viewPager를 연동해줍니다.
 - 반드시 연동 후에 ❕ 각 인덱스와 일치하는 탭 아이템 title을 작성해줍니다.
 
 <br>
 
