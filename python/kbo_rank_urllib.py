import urllib.request as req
import re   # 정규식 사용 모듈

# URL 
url = 'https://sports.news.naver.com/kbaseball/record/index.nhn?category=kbo'

# url 접속
html = req.urlopen(url)
# 응답 결과를 문자열로 변경 
html_code = str(html.read().decode('utf-8'))

tag_list = re.findall(r'(<span id=\"team_)(.+)(<\/span>)', html_code) # findall(r'정규식표현', 원본)

for index, tag in enumerate(tag_list):
    print(tag)
    print(index, '위', tag[1].split('>')[1])
