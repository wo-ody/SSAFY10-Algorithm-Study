SELECT COUNT(*) FISH_COUNT
FROM FISH_INFO FI, FISH_NAME_INFO FNI
WHERE FI.FISH_TYPE = FNI.FISH_TYPE
AND FNI.FISH_NAME IN ("BASS", "SNAPPER")
