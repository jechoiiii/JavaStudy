import logging

# 로거 정의
logger = logging.getLogger('main')
# 메세지의 출력 방법 정의 
stream_handler = logging.StreamHandler()
# 출력 방법을 로거에 등록
logger.addHandler(stream_handler)
# 출력 레벨을 설정 (DEBUG -> debug부터 출력, WARNING -> warning부터 출력)
logger.setLevel(logging.WARNING)

logger.debug('틀림!')
logger.info('처리되었음! 확인하세요')
logger.warning('조심!')
logger.error('에러발생!')
logger.critical('프로그램이 사망!')