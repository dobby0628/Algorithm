-- 코드를 작성해주세요
select count(*) as FISH_COUNT
from FISH_INFO join FISH_NAME_INFO
on FISH_INFO.FISH_TYPE = FISH_NAME_INFO.FISH_TYPE
where FISH_NAME like "BASS" or FISH_NAME like "SNAPPER";