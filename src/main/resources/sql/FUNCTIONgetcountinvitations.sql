CREATE OR REPLACE FUNCTION public.getcountinvitations(appid integer)
 RETURNS integer
 LANGUAGE plpgsql
AS $function$
declare
	cnt integer;
begin
	select count(*) into cnt from invitation where application = appid and date(createdon) = current_date ;
	return cnt;
end;
$function$
;