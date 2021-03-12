import urllib.request as req

# 다운로드 주소 
url = 'http://storage.googleapis.com/patents/grant_full_text/2014/ipg140107.zip'

# urlretrieve() 함수 호출(URL 주소, 다운로드할 파일명),
fname, header = req.urlretrieve(url, 'ipg140107.zip')

print(fname)
print(header)