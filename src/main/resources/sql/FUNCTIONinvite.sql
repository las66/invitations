CREATE OR REPLACE FUNCTION public.invite(user_id integer, app_id integer, phones text[])
 RETURNS void
 LANGUAGE plpgsql
AS $function$
begin
	insert into invitation(phone, author, application)
	select p, user_id, app_id
	from unnest(phones) as p;
	return;
end;
$function$
;
